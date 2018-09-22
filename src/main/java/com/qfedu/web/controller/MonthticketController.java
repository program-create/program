package com.qfedu.web.controller;


import com.qfedu.common.vo.R;
import com.qfedu.pojo.Monthticket;
import com.qfedu.service.MonthticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonthticketController {

    @Autowired
    private MonthticketService monthticketService;


    @PostMapping("/monthticketadd.do")
    @ResponseBody
    public R monthticketadd(int bid ,int votenum, int uid) {

        R r = new R();
        r.setCode(1001);
        r.setMsg("投票失败");

        if (monthticketService.saveMonthticket(bid, votenum, uid)) {
            r.setCode(1002);
            r.setMsg("投票成功");

        }
        return r;

    }


}
