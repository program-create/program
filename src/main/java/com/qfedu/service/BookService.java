package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Book;

public interface BookService {

    R addBook(Book book);

    R updateBook(Book book);

    Book queryBookByName(String bookname);

    Book queryBookById(Integer id);

}
