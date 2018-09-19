package com.qfedu.mapper;

import com.qfedu.pojo.Chapter;

public interface ChapterMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Chapter record);

    int insertSelective (Chapter record);

    Chapter selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Chapter record);

    int updateByPrimaryKeyWithBLOBs (Chapter record);

    int updateByPrimaryKey (Chapter record);

    int selectMax(int bookid);
}