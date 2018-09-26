package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
import com.qfedu.common.vo.R;
import com.qfedu.common.vo.RList;
import com.qfedu.pojo.Author;
import com.qfedu.pojo.History;
import com.qfedu.pojo.User;
import com.qfedu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private RedisUtil redisUtil;

    //添加一条阅读记录
    @PostMapping("/addhistory.do")
    @ResponseBody
    public R addhistory(History history, HttpServletRequest request) {

        String token = TokenTool.getToken(request);
        User user = (User) redisUtil.get(token);

        System.out.println(user);

        if (user != null) {
            history.setUid(user.getId());

            if (historyService.saveHistory(history)) {
                return R.ok();
            } else {
                return R.error();
            }
        } else {
            history.setUid(null);
            System.out.println(history);

            if (historyService.saveHistory(history)) {
                return R.ok();
            } else {
                return R.error();
            }
        }
    }

    //查询所有图书的阅读量排序(0正序1倒序)，前20本书
    @RequestMapping("/querytotalclick.do")
    @ResponseBody
    public RList querytotalclick(int param) {

        List list = historyService.queryTotalClick(param);
        RList rList = new RList();
        rList.setCode(1001);
        rList.setMsg("查询不到结果");
        if (list.size() > 0) {
            rList.setCode(1002);
            rList.setMsg("查询结果成功");
            rList.setDatas(list);
        }
        return rList;
    }

    //查询某一本书的阅读量（点击量）
    @RequestMapping("/querytotalclickbybookid.do")
    @ResponseBody
    public RList querytotalclickbybookid(int bookid) {

        List list = historyService.queryTotalClickByBookid(bookid);
        RList rList = new RList();
        rList.setCode(1001);
        rList.setMsg("查询不到结果");
        if (list.size() > 0) {
            rList.setCode(1002);
            rList.setMsg("查询结果成功");
            rList.setDatas(list);
        }
        return rList;
    }

    //查询一个人的阅读记录
    @RequestMapping("/queryhistorybyuid.do")
    @ResponseBody
    public RList queryhistorybyuid(int uid,HttpServletRequest request) {

        String token = TokenTool.getToken(request);
        User user = (User) redisUtil.get(token);

        List list = historyService.queryHistoryByUid(uid);
        RList rList = new RList();
        rList.setCode(1001);
        rList.setMsg("查询不到结果");
        if (list.size() > 0) {
            rList.setCode(1002);
            rList.setMsg("查询结果成功");
            rList.setDatas(list);
        }
        return rList;
    }

    //查询所有图书上个月的点击量
    @RequestMapping("/querylastmonthclick.do")
    @ResponseBody
    public RList querylastmonthclick(int param) {

        List list = historyService.queryLastMonthClick(param);
        RList rList = new RList();
        rList.setCode(1001);
        rList.setMsg("查询不到结果");
        if (list.size() > 0) {
            rList.setCode(1002);
            rList.setMsg("查询结果成功");
            rList.setDatas(list);
        }
        return rList;
    }


    //查询所有图书本月的点击量
    @RequestMapping("/querycurrentmonthclick.do")
    @ResponseBody
    public RList querycurrentmonthclick(int param) {

        List list = historyService.queryCurrentMonthClick(param);
        RList rList = new RList();
        rList.setCode(1001);
        rList.setMsg("查询不到结果");
        if (list.size() > 0) {
            rList.setCode(1002);
            rList.setMsg("查询结果成功");
            rList.setDatas(list);
        }
        return rList;
    }

}
