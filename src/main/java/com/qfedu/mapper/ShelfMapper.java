package com.qfedu.mapper;

import com.qfedu.pojo.Shelf;

public interface ShelfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shelf record);

    int insertSelective(Shelf record);

    Shelf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shelf record);

    int updateByPrimaryKey(Shelf record);
}