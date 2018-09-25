package com.qfedu.service.impl;

import com.qfedu.mapper.RewardMapper;
import com.qfedu.mapper.VchapterconsumeMapper;
import com.qfedu.pojo.Reward;
import com.qfedu.pojo.Vchapterconsume;
import com.qfedu.service.ConsumerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Administrator
 * @Date 2018/9/22 0022 12:02
 */
@Service
public class ConsumerecordServiceImpl implements ConsumerecordService {
    @Autowired
    private VchapterconsumeMapper vMapper;
    @Autowired
    private RewardMapper rMapper;

//    VIP章节消费记录新增
    @Override
    public boolean insertV (Vchapterconsume record) {
        int i = vMapper.insert(record);
        return true;
    }

//    打赏消费记录新增
    @Override
    public boolean insertR (Reward record) {
        int i = rMapper.insert(record);
        return true;
    }
}
