package com.qfedu.service;


import com.qfedu.common.vo.AuthorVo;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthorService {

    //作者注册
    R save(Author author, int args);

    //通过令牌获取Redis中作者ID修改作者信息
    R updateAuthor(AuthorVo authorVo, HttpServletRequest request);

    //登陆
    R authorLogin(String nickname, String password, HttpServletResponse response);

    //登陆时token已存在
    R loginCheck(HttpServletRequest request);

    //注销
    R loginOut(HttpServletRequest request);

    //作者密码重置--忘记密码 第一步
    R updatePassword1(String nickname,String idcard);

    //作者密码重置--忘记密码 第三步
    R updatePassword3(String nickname, String password);

    //通过作者ID修改作者头像
    R updateHeadimg(String headimg, HttpServletRequest request);
}
