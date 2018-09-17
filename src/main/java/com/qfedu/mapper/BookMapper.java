package com.qfedu.mapper;

import com.qfedu.pojo.Book;

public interface BookMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Book record);

    int insertSelective (Book record);

    Book selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Book record);

    int updateByPrimaryKey (Book record);
}