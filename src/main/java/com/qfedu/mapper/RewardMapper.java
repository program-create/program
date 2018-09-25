package com.qfedu.mapper;

import com.qfedu.pojo.Reward;

public interface RewardMapper {
    int deleteByPrimaryKey (Integer id);
    int insertSelective (Reward record);
    Reward selectByPrimaryKey (Integer id);
    int updateByPrimaryKeySelective (Reward record);
    int updateByPrimaryKey (Reward record);


    int insert (Reward record);

}