package com.qfedu.service.impl;

import com.qfedu.mapper.AwardrecordMapper;
import com.qfedu.pojo.Awardrecord;
import com.qfedu.service.AwardrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Administrator
 * @Date 2018/9/22 0022 11:45
 */
@Service
public class AwardrecordServiceImpl implements AwardrecordService {
    @Autowired
    private AwardrecordMapper mapper;

    @Override
    public boolean insert (Awardrecord record) {
        int insert = mapper.insert(record);
        if (insert > 0) {
            return true;
        } else {
            return false;
        }
    }
}
