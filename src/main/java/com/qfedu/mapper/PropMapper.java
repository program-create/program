package com.qfedu.mapper;

import com.qfedu.pojo.Prop;

public interface PropMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Prop record);

    int insertSelective (Prop record);

    Prop selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Prop record);

    int updateByPrimaryKey (Prop record);
}