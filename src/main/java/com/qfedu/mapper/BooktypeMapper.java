package com.qfedu.mapper;

import com.qfedu.pojo.Booktype;

public interface BooktypeMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Booktype record);

    int insertSelective (Booktype record);

    Booktype selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Booktype record);

    int updateByPrimaryKey (Booktype record);
}