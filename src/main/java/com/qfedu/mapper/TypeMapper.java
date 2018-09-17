package com.qfedu.mapper;

import com.qfedu.pojo.Type;

public interface TypeMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Type record);

    int insertSelective (Type record);

    Type selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Type record);

    int updateByPrimaryKey (Type record);
}