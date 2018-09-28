package com.qfedu.service.impl;

import com.qfedu.common.quartz.QuartzForDelSignFlag;
import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.EncrypUtil;
import com.qfedu.common.util.ShiroEncryUtil;
import com.qfedu.common.vo.R;
import com.qfedu.mapper.UserMapper;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean regist (User user, int code, int phonecode) {

        if (phonecode == code) {
            user.setPassword(ShiroEncryUtil.md5(user.getPassword()));
            return mapper.insert(user) > 0;
        }
        return false;
    }

    @Override
    public R login (String name, String password) {
        User user = mapper.selectByName(name);
        if (user == null) {
            return new R(1, "用户名不存在", null);
        } else {
            if (Objects.equals(user.getPassword(), ShiroEncryUtil.md5(password))) {
//                生成唯一登录令牌
                String token = EncrypUtil.md5Pass(user.getPhone().toString(), name);
//                将登录信息存储到redis上,app端使用
                redisUtil.set(token, user, 60 * 30);
                return new R(0, "登录成功", token);
            } else {
                return new R(2, "密码错误", null);
            }
        }
    }

    @Override
    public int updateLastLogin (int id) {
        return mapper.updateLastLogin(id);
    }


    @Override
    public int updateLoginDays (int num, int scores, int id) {
        return mapper.updateLoginDays(num, scores, id);
    }

    @Override
    public boolean selectByNickname (String nickname) {
        Integer i = mapper.selectByNickname(nickname);
        if (i != null) {
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean selectByPhone (String phone) {
        Integer i = mapper.selectByPhone(phone);
        if (i != null) {
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateDetail (User user) {
        return mapper.updateDetail(user) > 0;
    }


    @Override
    public R updatePass (String password, String oripass, int id) {
        String pass = mapper.selectOriPass(id);
        if (pass.equals(oripass)) {
            String newpass = ShiroEncryUtil.md5(password);
            if (mapper.updatePass(newpass, id) > 0) {
                return new R(0, "密码已修改", null);
            } else {
                return new R(9,"网络出故障了",null);
            }
        } else {
            return new R(1, "原密码错误", null);
        }
    }

    @Override
    public void delSignFlag () throws SchedulerException {
        //1、创建触发器   "0 59 23 ? * *" 每天晚上23:59触发
        Trigger trigger1=TriggerBuilder.newTrigger().withIdentity("trigger1","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 59 23 ? * *")).build();
        //2、创建定时的执行内容
        JobDetail detail = JobBuilder.newJob(QuartzForDelSignFlag.class).build();
        //3、创建执行器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //4、设置定时任务
        scheduler.scheduleJob(detail,trigger1);
        //5、执行
        scheduler.start();;

    }
}
