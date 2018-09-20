package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Mark;

public interface MarkService {
    R save(Mark mark);
    R listMark(int uid);
    R delMark(String[] id);
}
