package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.*;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("getCode.do")
    public R getCode (String phone) {
        ALiYunNote note = new ALiYunNote();
        String codekey = EncrypUtil.md5Pass(phone, "yyb");
//        将验证码存入redis缓存中，并设定有效时间为15min
        redisUtil.set(codekey, note.aLiYunNote(phone), 60 * 15);
        return new R(0, "验证码已发送，有效期15分钟", codekey);
    }

    //    1.user注册
    @PostMapping("userRegist.do")
    public R regist (User user, int code, String codekey) {
//        codekey需要通过前端传递到该接口
        int phonecode = (int) redisUtil.get(codekey);
        boolean b = service.regist(user, code, phonecode);
        if (b) {
            return R.ok();

        } else {
            return R.error();
        }
    }

    //    2.user登录
    @PostMapping("userLogin.do")
    public R login (String name, String password, HttpServletResponse response) {
        R r = service.login(name, password);
        String token = r.getData().toString();
        if (r.getCode() == 0) {
//            更改用户"上次登录时间"
            service.updateLastLogin(((User) redisUtil.get(token)).getId());
//            将标识存入cookie
            CookieUtil.setCK(response, "token", token);
        }
        return r;
    }

    //3.注册时检查用户名是否已存在
    @GetMapping("/checkName.do")
    public R checkUsername (String nickname) {
        boolean b = service.selectByNickname(nickname);
        if (b) {
            return new R(1, "用户名已存在", null);
        } else {
            return new R(0, "用户名可用", null);
        }
    }

    //4.注册时检查手机号是否已被注册
    @GetMapping("/checkPhone.do")
    public R checkPhone (String phone) {
        boolean b = service.selectByPhone(phone);
        if (b) {
            return new R(1, "手机号已被注册", null);
        } else {
            return new R(0, "手机号可用", null);
        }
    }

    //5.签到
    @RequestMapping("userSign.do")
    public R userSign (HttpServletRequest req, HttpServletResponse response) {
        String token = TokenTool.getToken(req);
        User user = (User) redisUtil.get(token);
        Integer id = user.getId();
        //外层判断：今天是否已经签到了！！
        String signFlag = "signFlag"+user.getNickname();
        if (redisUtil.hasKey(signFlag)) {
            return new R(0, "今天已经签到过了哦", null);
        } else {
            String signflag = "signFlag" + user.getNickname();
            redisUtil.set(signflag, "我是签到标识符，代表今天已签到", 60 * 60 * 24);
            if (user.getSigindays() == 0) {
                service.updateLoginDays(1, 10, id);
                return new R(1, "本周首次签到成功,+10潇湘币", null);
            } else if (user.getSigindays() > 0 && user.getSigindays() < 6) {
                if (SignTool.isContinuous(user.getLastsingin())) {
                    service.updateLoginDays(1, 5, id);
                    return new R(2, "连续签到成功,+5潇湘币", null);
                } else {
                    service.updateLoginDays((1 - user.getSigindays()), 5, id);
                    return new R(4, "签到成功,+5潇湘币", null);
                }
            } else {
                service.updateLoginDays(-6, 100, id);
                return new R(3, "连续签到七天,+100潇湘币", null);
            }
        }
    }

    //    6.用户信息详情
    @GetMapping("userDetail.do")
    public R userDetail (HttpServletRequest req) {
        String token = TokenTool.getToken(req);
        User user = (User) redisUtil.get(token);
        if (user != null) {
            return new R(0, "获取用户信息成功", user);
        } else {
            return new R(1, "登录已失效，请重新登录", null);
        }
    }

    //    7.用户信息修改
    @PostMapping("userUpdate.do")
    public R userUpdate (User user) {
        service.updateDetail(user);
        return R.ok();
    }

    //    8.用户密码修改
    @PostMapping("passUpdate.do")
    public R passUpdate (HttpServletRequest req, String password, String oripass) {
        String token = TokenTool.getToken(req);
        User user = (User) redisUtil.get(token);
        return service.updatePass(password, oripass, user.getId());
    }

    //    9.清除签到状态
    @RequestMapping("delSignFlag.do")
    public void delSignFlag () {
        try {
            service.delSignFlag();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    //   10.用户注销
    @RequestMapping("userLogout.do")
    public R userLogout (HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtil.getCk(request, "token");
        redisUtil.del(token);
        CookieUtil.delCK(response, "token");
        return new R(0, "注销成功", null);
    }
}
