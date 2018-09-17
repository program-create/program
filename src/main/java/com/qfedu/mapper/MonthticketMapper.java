package com.qfedu.mapper;

import com.qfedu.pojo.Monthticket;

public interface MonthticketMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Monthticket record);

    int insertSelective (Monthticket record);

    Monthticket selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Monthticket record);

    int updateByPrimaryKey (Monthticket record);
}