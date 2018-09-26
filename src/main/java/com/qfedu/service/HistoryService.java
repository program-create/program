package com.qfedu.service;

import com.qfedu.pojo.History;

import java.util.List;
import java.util.Map;

public interface HistoryService {
    //添加一次浏览
    boolean saveHistory(History history);
    //查询所有书的浏览量
    List<Map<String,Object>> queryTotalClick(int param);

    //查询某一本书的浏览量
    List<Map<String,Object>> queryTotalClickByBookid(int bookid);

    //查询所有书的上个月的浏览量
    List<Map<String,Object>> queryLastMonthClick(int param);

    //查询所有图书的本月的浏览量
    List<Map<String,Object>> queryCurrentMonthClick(int param);

    //查询某个人的浏览历史
    List<Map<String,Object>> queryHistoryByUid(int uid);


}
