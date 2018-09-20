package com.qfedu.mapper;

import com.qfedu.pojo.Authordetail;

public interface AuthordetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authordetail record);

    int insertSelective(Authordetail record);

    Authordetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authordetail record);

    int updateByPrimaryKey(Authordetail record);
}