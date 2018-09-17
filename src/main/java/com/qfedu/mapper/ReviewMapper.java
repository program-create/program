package com.qfedu.mapper;

import com.qfedu.pojo.Review;

public interface ReviewMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Review record);

    int insertSelective (Review record);

    Review selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Review record);

    int updateByPrimaryKeyWithBLOBs (Review record);

    int updateByPrimaryKey (Review record);
}