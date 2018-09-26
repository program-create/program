package com.qfedu.web.controller;


import com.qfedu.common.vo.R;
import com.qfedu.common.vo.RList;
import com.qfedu.pojo.Monthticket;
import com.qfedu.service.MonthticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/lastmonthticket.do")
    @ResponseBody
    public RList lastmonth(int param) {
        RList r = new RList();
        r.setCode(1001);
        r.setMsg("无法查询到结果");
        if (monthticketService.queryLastMonthticket(param) != null) {
            r.setCode(1002);
            r.setMsg("查询结果成功");
            r.setDatas(monthticketService.queryLastMonthticket(param));
        }
        return r;
    }

    @RequestMapping("/currentmonthticket.do")
    @ResponseBody
    public RList currentmonth(int param) {
        RList r = new RList();
        r.setCode(1001);
        r.setMsg("无法查询到结果");
        if (monthticketService.queryCurrentMonthticket(param) != null) {
            r.setCode(1002);
            r.setMsg("查询结果成功");
            r.setDatas(monthticketService.queryCurrentMonthticket(param));
        }
        return r;
    }


}
