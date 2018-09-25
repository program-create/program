package com.qfedu.mapper;

import com.qfedu.pojo.Awardrecord;

public interface AwardrecordMapper {
    int deleteByPrimaryKey (Integer id);
    int insertSelective (Awardrecord record);
    Awardrecord selectByPrimaryKey (Integer id);
    int updateByPrimaryKeySelective (Awardrecord record);
    int updateByPrimaryKey (Awardrecord record);

//    插入奖励记录
    int insert (Awardrecord record);
}