package com.qfedu.mapper;

import com.qfedu.common.vo.ShelfVo;
import com.qfedu.pojo.Shelf;

import java.util.List;

public interface ShelfMapper {

    int deleteById(List list);

    int insert(Shelf record);

    int insertSelective(Shelf record);

    Shelf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shelf record);

    int updateByPrimaryKey(Shelf record);

    List<ShelfVo> selectbyuid(int uid);

}