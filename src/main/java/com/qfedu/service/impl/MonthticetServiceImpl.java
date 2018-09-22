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
    public boolean saveMonthticket(int bookid, int votename, int uid) {

        if (monthticketMapper.insertMonthticket(bookid, votename, uid) > 0) {


            int addnum = bookMapper.selectMonthticket(bookid) + votename;

            System.out.println(addnum);
            System.out.println(votename);

            bookMapper.updateMonthticket(bookid, addnum);
            System.out.println("哈哈" + bookMapper.updateMonthticket(bookid, addnum));
            if (walletMapper.selectMonthticket(uid) > votename) {
                int delnum = walletMapper.selectMonthticket(uid) - votename;
                System.out.println(delnum);
                walletMapper.updateMonthticket(uid, delnum);
            }

            return true;
        }  else {

            return false;
        }

    }
}
