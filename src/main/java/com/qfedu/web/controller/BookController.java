package com.qfedu.web.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.TokenTool;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RedisUtil redisUtil;


    @PostMapping("/addbook.do")
    @ResponseBody
    public R addbook (Book book, HttpServletRequest request) {
        String token = TokenTool.getToken(request);

        Author author = (Author) redisUtil.get(token);

        book.setAuid(author.getId());

        return bookService.addBook(book);
    }

    //修改图书信息
    @RequestMapping("/updatebook.do")
    @ResponseBody
    public R updatebook(Book book, HttpServletRequest request) {

        String token = TokenTool.getToken(request);

        Author author = (Author) redisUtil.get(token);

        if (author.getId() == book.getAuid()) {

            return bookService.updateBook(book);
        } else {
            R r = new R();
            r.setCode(2);
            r.setMsg("只有作者本人才能修改图书信息");

            return r;
        }
    }

    //根据书名查询图书
    @RequestMapping("/querybookbyname.do")
    @ResponseBody
    public R querybookbyname(String bookname) {

        System.out.println(bookname);

        R r=new R();
        Map<String, Object> map = bookService.queryBookByName(bookname);

        if (map != null ) {
            r.setCode(1001);
            r.setMsg("查询图书成功");
            r.setData(map);
        } else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setData(null);
        }
        return r;
    }

    //根据书名查询图书
    @RequestMapping("/querybookbyid.do")
    @ResponseBody
    public R querybookbyid(int id) {

        R r = new R();
        Map<String,Object> map = bookService.queryBookById(id);

        if (map != null ) {
            r.setCode(1001);
            r.setMsg("查询图书成功");
            r.setData(map);

            return r;
        } else {
            r.setCode(1002);
            r.setMsg("查询失败");
            r.setData(null);
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
