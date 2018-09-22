package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.User;
import com.qfedu.pojo.Wallet;
import com.qfedu.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Administrator
 * @Date 2018/9/21 0021 21:43
 */
@RestController
public class WalletController {
    @Autowired
    private WalletService service;
    @Autowired
    private RedisUtil redisUtil;

//    获取当前用户钱包详情：潇湘币、月票
    @GetMapping("wallet.do")
    public R wallet (HttpServletRequest request) {
        String token = TokenTool.getToken(request);
        if (token == null || token.equals("")) {
            return new R(8, "登录已失效，请重新登录", null);
        } else {
            User user = (User) redisUtil.get(token);
            return service.selectByUid(user.getId());
        }
    }


}
