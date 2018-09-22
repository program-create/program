package com.qfedu.web.controller;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.redis.JedisUtil;
import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Mark;
import com.qfedu.pojo.User;
import com.qfedu.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MarkController {
    @Autowired
    private MarkService markService;
    @Autowired
    private RedisUtil redisUtil;
    //保存我的书架
    @RequestMapping("/savemark.do")
    @ResponseBody
    public R saveMark(Mark mark,HttpServletRequest request){
        String token = TokenTool.getToken(request);
        if (token!=null&&token.length()>0){
            User user = (User) redisUtil.get(token);
            mark.setUid(user.getId());
            return  markService.save(mark);
        }
        return R.error();
    }

    //展示我的书签
    @RequestMapping("/listmark.do")
    @ResponseBody
    public R listMark(HttpServletRequest request){
        String token = TokenTool.getToken(request);
        //判断吧token是否为空
        if (token!=null){
            User  user = (User) redisUtil.get(token);
            try {
                R r = markService.listMark(user.getId());
                return r;
            }catch (Exception e){
                return R.error();
            }
        }
        return R.error();
    }
    //删除我的书签
    @RequestMapping("/delmark.do")
    @ResponseBody
    public R delMark(HttpServletRequest request){
        String[] arr = request.getParameterValues("id");
        return markService.delMark(arr);
    }
}
