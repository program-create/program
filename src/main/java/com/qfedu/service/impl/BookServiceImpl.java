package com.qfedu.service.impl;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.R;
import com.qfedu.mapper.BookMapper;
import com.qfedu.pojo.Book;
import com.qfedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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
    public Map<String,Object> queryBookByName(String bookname) {

        return bookMapper.selectByName(bookname);
    }

    @Override
    public Map<String, Object> queryBookById(Integer id) {


        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo queryBookByType(int typeid, int page, int pagenum) {

        int index = 0;

        if (page > 0) {
            index = (page - 1) * pagenum;

        }
        List<Map<String,Object>> list = bookMapper.selectByType(typeid,index,pagenum);

        int count = bookMapper.selectcounttype(typeid) ;

        return PageVo.createPage(list,count);

    }

    @Override
    public PageVo queryBookByTagOne(int styleid, int page, int pagenum) {
        int index = 0;

        if (page > 0) {
            index = (page - 1) * pagenum;

        }
        List<Map<String,Object>> list = bookMapper.selectByTagTwo(styleid,index,pagenum);

        int count = bookMapper.selectcountstyle(styleid) ;

        return PageVo.createPage(list,count);
    }

    @Override
    public PageVo queryBookByTagTwo(int schoolsid, int page, int pagenum) {
        int index = 0;

        if (page > 0) {
            index = (page - 1) * pagenum;

        }
        List<Map<String,Object>> list = bookMapper.selectByTagTwo(schoolsid,index,pagenum);

        int count = bookMapper.selectcountschools(schoolsid) ;

        return PageVo.createPage(list,count);
    }

    @Override
    public PageVo queryBookByTagThree(int elementid, int page, int pagenum) {
        int index = 0;

        if (page > 0) {
            index = (page - 1) * pagenum;

        }
        List<Map<String,Object>> list = bookMapper.selectByTagThree(elementid,index,pagenum);

        int count = bookMapper.selectcountelement(elementid) ;

        return PageVo.createPage(list,count);
    }


}
