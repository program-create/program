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


@Service
public class MonthticetServiceImpl implements MonthticketService {

    @Autowired
    private MonthticketMapper monthticketMapper;
    @Autowired
    private WalletMapper walletMapper;
    @Autowired
    private BookMapper bookMapper;


    @Override
    public boolean saveMonthticket(Monthticket monthticket) {
        Book book = new Book();
        Wallet wallet= new Wallet();

        int addnum = book.getMonthticket() + monthticket.getVotenum();
        bookMapper.updateMonthticket(monthticket.getBookid(),addnum);
        if (wallet.getMonthticket() > monthticket.getVotenum()) {
            int delnum = wallet.getMonthticket() - monthticket.getVotenum();
            walletMapper.updateMonthticket(monthticket.getUid(), monthticket.getVotenum());
        }


        return monthticketMapper.insertMonthticket(monthticket) > 0;
    }
}
