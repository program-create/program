package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Review;
import com.qfedu.pojo.User;
import com.qfedu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private RedisUtil redisUtil;
    //保存书评
    @RequestMapping("/savereview.do")
    @ResponseBody
    public R saveReview(Review review,HttpServletRequest request){
        String token = TokenTool.getToken(request);
        if (token!=null){
            User user = (User) redisUtil.get(token);
            review.setUid(user.getId());
            return reviewService.save(review);
        }
        return R.error();
    }
    //查询我的书评
    @RequestMapping("/listReview.do")
    @ResponseBody
    public R listReview(HttpServletRequest request){
        String token = TokenTool.getToken(request);
        if (token!=null){
           User user = (User) redisUtil.get(token);
           return reviewService.listReview(user.getId());
        }
        return R.error();
    }

    @RequestMapping("/delreview.do")
    @ResponseBody
    public R delreview(int id){
        return reviewService.delReview(id);
    }
}
