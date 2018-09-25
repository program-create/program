package com.qfedu.mapper;

import com.qfedu.pojo.Vchapterconsume;

public interface VchapterconsumeMapper {
    int deleteByPrimaryKey (Integer id);
    int insertSelective (Vchapterconsume record);
    Vchapterconsume selectByPrimaryKey (Integer id);
    int updateByPrimaryKeySelective (Vchapterconsume record);
    int updateByPrimaryKey (Vchapterconsume record);

    int insert (Vchapterconsume record);



}