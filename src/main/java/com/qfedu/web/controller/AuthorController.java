package com.qfedu.web.controller;

import com.qfedu.common.util.CookieUtil;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;
import com.qfedu.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //作者注册
    @RequestMapping("/authorsave.do")
    @ResponseBody
    public R save(Author author) {
        System.out.println("注册信息》》》》："+ author);
        return authorService.save(author);
    }

    //作者登陆
    @RequestMapping("/authorlogin.do")
    @ResponseBody
    public R authorLogin(String nickname, String password, HttpServletRequest request, HttpServletResponse responsep) {
        //查看token是否存在
        String token = CookieUtil.getCk(request,"author");
        if (token != null) {
            //登陆
            R r = authorService.authorLogin(nickname, password);
            if (r.getCode() == 0) {
                //登录成功，需要将令牌存储到Cookie
                CookieUtil.setCK(responsep, "author", r.getData().toString());
            }
            return r;
        } else {
            //检查token是否过期
            return authorService.loginCheck(token);
        }
    }

    //单点登陆检查
    @RequestMapping("/ssologinAuthor.do")
    public R logigcheck( HttpServletRequest request){
        //查看token是否存在
        String token=CookieUtil.getCk(request,"userauth");
        if(token!=null) {
            //重置token时间并返回用户信息
            return authorService.loginCheck(token);
        }else {
            return R.error();
        }
    }


    //作者信息修改




}
