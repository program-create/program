package com.qfedu.web.controller;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Author;
import com.qfedu.pojo.Book;
import com.qfedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //根据图书类型查询图书
    @RequestMapping("querybookbytype.do")
    @ResponseBody
    public PageVo querybookbytype( int typeid ,int page, int pagenum) {

        PageVo pageVo = new PageVo();

        if (bookService.queryBookByType(typeid, page, pagenum).getData().size() > 0) {

            return bookService.queryBookByType(typeid, page, pagenum);
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("查询不到结果");
            return pageVo;
        }
    }

    @RequestMapping("querybookbystyle.do")
    @ResponseBody
    public PageVo querybookbystyle( int styleid ,int page, int pagenum) {

        PageVo pageVo = new PageVo();

        if (bookService.queryBookByTagOne(styleid, page, pagenum).getData().size() > 0) {

            return bookService.queryBookByType(styleid, page, pagenum);
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("查询不到结果");
            return pageVo;
        }
    }

    @RequestMapping("querybookbyschools.do")
    @ResponseBody
    public PageVo querybookbyschools( int schoolsid ,int page, int pagenum) {

        PageVo pageVo = new PageVo();

        if (bookService.queryBookByTagTwo(schoolsid, page, pagenum).getData().size() > 0) {

            return bookService.queryBookByType(schoolsid, page, pagenum);
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("查询不到结果");
            return pageVo;
        }
    }

    @RequestMapping("querybookbyelement.do")
    @ResponseBody
    public PageVo querybookbyelement( int elementid ,int page, int pagenum) {

        PageVo pageVo = new PageVo();

        if (bookService.queryBookByTagThree(elementid, page, pagenum).getData().size() > 0) {

            return bookService.queryBookByType(elementid, page, pagenum);
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("查询不到结果");
            return pageVo;
        }
    }

}
