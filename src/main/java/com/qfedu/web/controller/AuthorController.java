package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.ALiYunNote;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.AuthorVo;
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
    @Autowired
    private RedisUtil redisUtil;

    //作者注册
    @RequestMapping("/authorsave.do")
    @ResponseBody
    public R save(Author author,Integer args) {
        return authorService.save(author,args);
    }

    //阿里云短信验证
    @RequestMapping("/aliyunnote.do")
    @ResponseBody
    public R note(String phone) {
        //创建阿里云短信工具类对象
        ALiYunNote aLiYun = new ALiYunNote();
        //调用阿里云短信服务
        int args = aLiYun.aLiYunNote(phone);
        if (args != 0) {
            //将生成的验证码存入Redis中
            redisUtil.set(phone,args, 5*60);
            return R.ok();
        }
        return R.error();
    }

    //作者登陆--第一次登陆使用
    @RequestMapping("/authorlogin.do")
    @ResponseBody
    public R authorLogin(String nickname, String password,HttpServletRequest request, HttpServletResponse response) {
        return authorService.authorLogin(nickname, password, response);
    }

    //单点登陆检查
    @RequestMapping("/ssologinauthor.do")
    @ResponseBody
    public R logigcheck( HttpServletRequest request){
        return authorService.loginCheck(TokenTool.getToken(request));
    }


    //作者信息修改
    @RequestMapping("/updateauthor.do")
    @ResponseBody
    public R updateAuthor(AuthorVo authorVo, HttpServletRequest request){
        System.out.println(authorVo);
        return authorService.updateAuthor(authorVo,request);
    }

    //作者密码重置--忘记密码 第一步
    @RequestMapping("/updatepassword1.do")
    @ResponseBody
    public R updatePassword1(String nickname,String idcard){
        return authorService.updatePassword1(nickname, idcard);
    }

    //作者密码重置--忘记密码 第二步
    @RequestMapping("/updatepassword2.do")
    @ResponseBody
    public R updatePassword2(Integer args, String phone){
        if (args == redisUtil.get(phone)) {
            return R.ok();
        }
        return R.error();
    }

    //作者密码重置--忘记密码 第三步
    @RequestMapping("/updatepassword3.do")
    @ResponseBody
    public R updatePassword3(String nickname, String password){
        return authorService.updatePassword3(nickname, password);
    }

}
