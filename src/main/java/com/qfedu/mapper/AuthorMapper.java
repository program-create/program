package com.qfedu.mapper;

import com.qfedu.pojo.Author;

public interface AuthorMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Author record);

    int insertSelective (Author record);

    Author selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Author record);

    int updateByPrimaryKey (Author record);
}