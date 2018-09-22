package com.qfedu.service;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Book;

public interface BookService {

    R addBook(Book book);

    R updateBook(Book book);

    Book queryBookByName(String bookname);

    Book queryBookById(Integer id);

    PageVo queryBookByType(int typeid, int page,int pagenum);

    PageVo queryBookByTagOne(int styleid , int page,int pagenum);

    PageVo queryBookByTagTwo(int schoolsid , int page,int pagenum);

    PageVo queryBookByTagThree(int elementid , int page,int pagenum);

}
