package com.qfedu.mapper;

import com.qfedu.pojo.Bookimg;

public interface BookimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookimg record);

    int insertSelective(Bookimg record);

    Bookimg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookimg record);

    int updateByPrimaryKey(Bookimg record);
}