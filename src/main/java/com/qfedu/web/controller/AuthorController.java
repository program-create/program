package com.qfedu.web.controller;

import com.qfedu.common.redis.JedisUtil;
import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.ALiYunNote;
import com.qfedu.common.util.CookieUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;
import com.qfedu.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private RedisUtil redisUtil;

    //作者注册
    @RequestMapping("/authorsave.do")
    @ResponseBody
    public R save(Author author,Integer args) {
        System.out.println("注册信息》》》》："+ author);
        return authorService.save(author,args);
    }

    //阿里云短信验证
    @RequestMapping("/aliyunnote.do")
    @ResponseBody
    public R note(Author author) {
        //创建阿里云短信工具类对象
        ALiYunNote aLiYun = new ALiYunNote();
        //调用阿里云短信服务
        int args = aLiYun.aLiYunNote(author.getPhone());
        //将生成的验证码存入Redis中
        redisUtil.set(author.getPhone(),args, 5*60);
        return R.ok();
    }

    //作者登陆
    @RequestMapping("/authorlogin.do")
    @ResponseBody
    public R authorLogin(String nickname, String password,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("用户名："+nickname);
        return authorService.authorLogin(nickname, password, response);
    }

    //单点登陆检查
    @RequestMapping("/ssologinAuthor.do")
    public R logigcheck( HttpServletRequest request){
        return authorService.loginCheck(TokenTool.getToken(request));
    }


    //作者信息修改




}
