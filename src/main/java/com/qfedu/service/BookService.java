package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    R addBook(Book book);

    R updateBook(Book book);

    Book queryBookByName(String bookname);

    Book queryBookById(Integer id);

    List<Map<String ,  Object>> queryBookByType(int typeid);

    List<Map<String ,  Object>> queryBookByTagOne(int typeid);

}
