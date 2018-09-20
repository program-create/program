package com.qfedu.mapper;

import com.qfedu.common.vo.ReViewVo;
import com.qfedu.pojo.Review;

import java.util.List;

public interface ReviewMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Review record);

    int insertSelective (Review record);

    Review selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Review record);

    int updateByPrimaryKeyWithBLOBs (Review record);

    int updateByPrimaryKey (Review record);

    List<ReViewVo> selectByUid(int uid);
}