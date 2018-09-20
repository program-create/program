package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.User;
import org.quartz.SchedulerException;

public interface UserService {
    //    1.注册
    boolean regist (User record, int code, int phonecode);

    //    2.登录
    R login (String name, String password);

    //    2.1.记录登录时间
    int updateLastLogin (int id);

    //    2.2.签到：更改连续登录天数
    int updateLoginDays (int num, int scores, int id);

    //    3.检查用户名
    boolean selectByNickname (String nickname);

    //    4.检查手机号
    boolean selectByPhone (String phone);

    //    5.修改个用户信息
    boolean updateDetail (User user);

    //    6.2.修改用户密码
    R updatePass (String password, String oripass, int id);

    //    7.签到状态
    public void delSignFlag() throws SchedulerException;
}
