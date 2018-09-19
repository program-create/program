package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Shelf;
import com.qfedu.pojo.User;
import com.qfedu.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ShelfController {
    @Autowired
    private ShelfService shelfService;
    @Autowired
    private RedisUtil redisUtil;
    //向我的书架添加小说
    @RequestMapping("/addbook.do")
    @ResponseBody
    public R addShelf(Shelf shelf, HttpServletRequest request){
        //从cookie中获取用户信息
        String token = TokenTool.getToken(request);
        User user = (User) redisUtil.get(token);
        if (user==null){
            return R.error();
        }else {
            //获取当前用户信息的id
            shelf.setUid(user.getId());
            return shelfService.save(shelf);
        }
    }
}
