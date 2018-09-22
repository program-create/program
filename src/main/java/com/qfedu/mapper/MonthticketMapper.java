package com.qfedu.mapper;

import org.apache.ibatis.annotations.Param;

public interface MonthticketMapper {

    //插入一条投票记录
    int insertMonthticket(@Param("bookid") int bookid,@Param("votenum") int votename, @Param("uid") int uid);


}