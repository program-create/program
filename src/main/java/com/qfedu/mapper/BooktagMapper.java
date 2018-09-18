package com.qfedu.mapper;

import com.qfedu.pojo.Booktag;

public interface BooktagMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Booktag record);

    int insertSelective (Booktag record);

    Booktag selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Booktag record);

    int updateByPrimaryKey (Booktag record);
}