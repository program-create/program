package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.ALiYunNote;
import com.qfedu.common.util.FileUtils233;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.AuthorVo;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;
import com.qfedu.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

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
        return authorService.loginCheck(request);
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

    //上传头像
    @RequestMapping("/pushheadimg.do")
    @ResponseBody
    public R updateHeadimg(@RequestParam("headimg")MultipartFile headimg, HttpServletRequest request) {
        //获取token
        String token = TokenTool.getToken(request);
        if (token != null) {
            //从获取Redis用户信息
            Author author = (Author) redisUtil.get(token);
            if (author != null) {
                //利用【FileUtils233.createDir】创建保存图片的文件夹【】
                File dir=FileUtils233.createDir(request.getServletContext().getRealPath("/"), "ZeroBook");
                //File file=new File(保存文件路径,前端获取文件名称));
                File file=new File(dir,FileUtils233.createFileName(headimg.getOriginalFilename()));
                try {
                    //把前端图片存入文件夹
                    headimg.transferTo(file);
                    //刷新令牌时间
                    redisUtil.expire(token,30*60);
                    //返回上传文件路径【ResultVo.setOK(时间动态文件夹+File.separator+保存图片文件夹+File.separator+图片名称);】
                    return new R(0,"上传成功",dir.getParentFile().getName()+File.separator+dir.getName()+File.separator+file.getName());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return R.error();
                }
            }
            return new R(1, "令牌失效", null);
        }
        return R.error();
    }

    //通过作者ID修改作者头像
    @RequestMapping("/updateheadimg.do")
    @ResponseBody
    public R updateHeadimg(String headimg, HttpServletRequest request){
        System.out.println(headimg);
        return authorService.updateHeadimg(headimg,request);
    }

    //注销
    @RequestMapping("/updateheadimg.do")
    @ResponseBody
    public R loginOut(HttpServletRequest request){
        return authorService.loginOut(request);
    }
}
