package com.qfedu.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.mapper.BookMapper;
import com.qfedu.pojo.Book;
import com.qfedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public R addBook(Book book) {

        if (bookMapper.insertSelective(book) > 0) {
            return R.ok();
        } else {
           return R.error();
        }
    }

    @Override
    public R updateBook(Book book) {

        if (bookMapper.updateByPrimaryKeySelective(book) > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @Override
    public Book queryBookByName(String bookname) {



        return bookMapper.selectByName(bookname);
    }

    @Override
    public Book queryBookById(Integer id) {


        return bookMapper.selectByPrimaryKey(id);
    }
}
