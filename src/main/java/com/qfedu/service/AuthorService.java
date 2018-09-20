package com.qfedu.service;


import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;

import javax.servlet.http.HttpServletResponse;

public interface AuthorService {

    //作者注册
    R save(Author author, int args);

    //通过作者名修改作者信息
    R updateById(String nickname);

    //根据作者名查询作者信息
    R authorLogin(String nickname, String password, HttpServletResponse response);

    //登陆时token已存在
    R loginCheck(String token);

    //注销
    R loginOut(String token);
}
