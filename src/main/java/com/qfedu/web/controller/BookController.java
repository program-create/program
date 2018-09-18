package com.qfedu.web.controller;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;
import com.qfedu.pojo.Book;
import com.qfedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/addbook.do")
    public R addbook (Book book, HttpSession session) {
        Author author = (Author) session.getAttribute("author");

        book.setAuid(author.getId());

        return bookService.addBook(book);
    }

    //修改图书信息
    @RequestMapping("/updatebook.do")
    public R updatebook(Book book, HttpSession session) {

        Author author = (Author) session.getAttribute("author");

        return bookService.updateBook(book);
    }

    //查询图书根据书名
    @RequestMapping("querybookbynaem.do")
    public R querybookbyname(String bookname) {

        R r=new R();
        Book book = bookService.queryBookByName(bookname);

        if (book != null ) {
            r.setCode(1001);
            r.setMsg("查询图书成功");
            r.setData(book);

        } else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setData(book);
        }

        return r;

    }




}
