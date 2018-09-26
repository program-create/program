package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;
import com.qfedu.pojo.History;
import com.qfedu.pojo.User;
import com.qfedu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/addhistory.do")
    public R addhistory(History history, HttpServletRequest request) {

        String token = TokenTool.getToken(request);
        User user = (User) redisUtil.get(token);

        if (user != null) {
            history.setUid(user.getId());

            if (historyService.saveHistory(history)) {
                return R.ok();
            } else {
                return R.error();
            }
        }

        history.setUid(null);

        if (historyService.saveHistory(history)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}
