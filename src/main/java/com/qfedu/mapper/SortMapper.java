package com.qfedu.mapper;

import com.qfedu.pojo.Sort;

public interface SortMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Sort record);

    int insertSelective (Sort record);

    Sort selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Sort record);

    int updateByPrimaryKey (Sort record);
}