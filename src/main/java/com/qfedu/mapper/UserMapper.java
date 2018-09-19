package com.qfedu.mapper;

import com.qfedu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserMapper {
    int deleteByPrimaryKey (Integer id);
    User selectByPrimaryKey (Integer id);
    int updateByPrimaryKeySelective (User record);
    int updateByPrimaryKey (User record);
//    1.注册
    int insert (User record);
//    2.登录
    User selectByName(String name);
//    2.1.记录登录时间
    int updateLastLogin(int id);

//    2.2.签到：更改连续签到天数
    int updateLoginDays(@Param("num") int num,@Param("scores") int scores, @Param("id") int id);

//    3.检查用户名
    Integer selectByNickname(String nickname);
//    4.检查手机号
    Integer selectByPhone(String phone);
//    5.修改个用户信息
    int updateDetail(User user);
//    6.1.检查用户原密码
    String selectOriPass(int id);
//    6.2.修改用户密码
    int updatePass(@Param("password") String password,@Param("id") int id);
}