package com.qfedu.service.impl;

import com.qfedu.mapper.HistoryMapper;
import com.qfedu.pojo.History;
import com.qfedu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public boolean saveHistory(History history) {
        return false;
    }

    @Override
    public List<Map<String, Object>> queryTotalClick(int param) {
        return historyMapper.selectTotalClick(param);
    }

    @Override
    public List<Map<String, Object>> queryTotalClickByBookid(int bookid) {
        return historyMapper.selectTotalClickByBookid(bookid);
    }

    @Override
    public List<Map<String, Object>> queryLastMonthClick(int param) {
        return historyMapper.selectLastMonthClick(param);
    }

    @Override
    public List<Map<String, Object>> queryCurrentMonthClick(int param) {
        return historyMapper.selectCurrentMonthClick(param);
    }

    @Override
    public List<Map<String, Object>> queryHistoryByUid(int uid) {
        return historyMapper.selectHistoryByUid(uid);
    }
}
