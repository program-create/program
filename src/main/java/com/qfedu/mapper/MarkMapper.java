package com.qfedu.mapper;

import com.qfedu.pojo.Mark;

public interface MarkMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Mark record);

    int insertSelective (Mark record);

    Mark selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Mark record);

    int updateByPrimaryKey (Mark record);
}