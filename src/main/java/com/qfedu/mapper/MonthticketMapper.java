package com.qfedu.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MonthticketMapper {

    //插入一条投票记录
    int insertMonthticket(@Param("bookid") int bookid,@Param("votenum") int votename, @Param("uid") int uid);

    //查询所有书上个月所获得的月票数量
    List<Map<String , Object>> selectLastMonthTicket(@Param("param") int param);

    //查询所有书本个月所获得的月票数量
    List<Map<String , Object>> selectCurrentMonthTicket(@Param("param") int param);


}