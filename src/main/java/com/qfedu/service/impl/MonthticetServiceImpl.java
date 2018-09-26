package com.qfedu.service.impl;

import com.qfedu.mapper.BookMapper;
import com.qfedu.mapper.MonthticketMapper;
import com.qfedu.mapper.WalletMapper;
import com.qfedu.pojo.Book;
import com.qfedu.pojo.Monthticket;
import com.qfedu.pojo.Wallet;
import com.qfedu.service.MonthticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MonthticetServiceImpl implements MonthticketService {

    @Autowired
    private MonthticketMapper monthticketMapper;
    @Autowired
    private WalletMapper walletMapper;
    @Autowired
    private BookMapper bookMapper;


    @Override
    public boolean saveMonthticket(int bookid, int votename, int uid) {

        if (monthticketMapper.insertMonthticket(bookid, votename, uid) > 0) {

            int addnum = bookMapper.selectMonthticket(bookid) + votename;

            bookMapper.updateMonthticket(bookid, addnum);
            if (walletMapper.selectMonthticket(uid) > votename) {
                int delnum = walletMapper.selectMonthticket(uid) - votename;
                walletMapper.updateMonthticket(uid, delnum);
            }

            return true;
        }  else {

            return false;
        }

    }

    @Override
    public List<Map<String, Object>> queryLastMonthticket(int param) {
        return monthticketMapper.selectLastMonthTicket(param);
    }

    @Override
    public List<Map<String, Object>> queryCurrentMonthticket(int param) {
        return monthticketMapper.selectCurrentMonthTicket(param);
    }
}
