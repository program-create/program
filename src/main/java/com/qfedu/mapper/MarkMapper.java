package com.qfedu.mapper;

import com.qfedu.common.vo.ShelfVo;
import com.qfedu.pojo.Mark;

import java.util.List;

public interface MarkMapper {
    int deleteById (List list);

    int insert (Mark record);

    int insertSelective (Mark record);

    Mark selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Mark record);

    int updateByPrimaryKey (Mark record);

    List<ShelfVo> selectByUid(int uid);
}