package com.qfedu.mapper;

import com.qfedu.pojo.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HistoryMapper {
    int deleteByPrimaryKey (Integer id);
    //一次点击即为一次浏览,增加一次浏览
    int insert (History record);

    int insertSelective (History record);

    History selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (History record);

    int updateByPrimaryKey (History record);
    //查询所有书的浏览量
    List<Map<String,Object>> selectTotalClick(@Param("param") int param);

    //查询某一本书的浏览量（点击量）
    List<Map<String,Object>> selectTotalClickByBookid(@Param("bookid") int bookid);

    //查询上月所有图书的点击量
    List<Map<String,Object>> selectLastMonthClick(@Param("param") int param);

    //查询当月所有图书的阅读量
    List<Map<String,Object>> selectCurrentMonthClick(@Param("param") int param);

    //查询一个人的浏览记录
    List<Map<String,Object>> selectHistoryByUid(@Param("uid") int uid);


}