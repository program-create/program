package com.qfedu.service;

import com.qfedu.pojo.Reward;
import com.qfedu.pojo.Vchapterconsume;

public interface ConsumerecordService {
    //    v章节消费记录
    boolean insertV (Vchapterconsume record);

    //    打赏消费记录
    boolean insertR (Reward record);
}
