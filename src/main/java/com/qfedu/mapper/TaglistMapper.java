package com.qfedu.mapper;

import com.qfedu.pojo.Taglist;

public interface TaglistMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Taglist record);

    int insertSelective (Taglist record);

    Taglist selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Taglist record);

    int updateByPrimaryKey (Taglist record);
}