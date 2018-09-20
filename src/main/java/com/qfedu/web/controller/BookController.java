package com.qfedu.web.controller;

import com.qfedu.common.vo.R;
import com.qfedu.common.vo.RList;
import com.qfedu.pojo.Author;
import com.qfedu.pojo.Book;
import com.qfedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/querybookbyname.do")
    @ResponseBody
    public R querybookbyname(String bookname) {

        System.out.println(bookname);


        R r=new R();
        Book book = bookService.queryBookByName(bookname);
        System.out.println(book);

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

    //查询图书根据书名
    @RequestMapping("/querybookbyid.do")
    @ResponseBody
    public RList<Book> querybookbyid(int id) {

        System.out.println(id);


        RList<Book> r=new RList<Book>();
        List<Book> list = new ArrayList<Book>();
        Book book = bookService.queryBookById(id);

        list.add(book);
        System.out.println(book);

        if (book != null ) {
            r.setCode(1001);
            r.setMsg("查询图书成功");
            r.setDatas(list);

            return r;
        } else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setDatas(list);
            return r;
        }

    }


}
