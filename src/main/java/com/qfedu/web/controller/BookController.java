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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public R querybookbyid(int id) {

        R r = new R();
        Book book = bookService.queryBookById(id);

        if (book != null ) {
            r.setCode(1001);
            r.setMsg("查询图书成功");
            r.setData(book);

            return r;
        } else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setData(book);
            return r;
        }
    }

    @RequestMapping("querybookbytype.do")
    @ResponseBody
    public RList querybookbytype( int typeid) {
        List<Map<String,Object>> mapList = bookService.queryBookByType(typeid);

        RList r = new RList();
        if (mapList.size() > 0) {
            r.setCode(1001);
            r.setMsg("查询成功");
            r.setDatas(mapList);

            return r;
        }  else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setDatas(mapList);
            return r;
        }
    }

    @RequestMapping("querybookbytagone.do")
    @ResponseBody
    public RList querybookbytagone( int typeid) {
        List<Map<String,Object>> mapList = bookService.queryBookByTagOne(typeid);

        RList r = new RList();
        if (mapList.size() > 0) {
            r.setCode(1001);
            r.setMsg("查询成功");
            r.setDatas(mapList);

            return r;
        }  else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setDatas(mapList);
            return r;
        }
    }


}
