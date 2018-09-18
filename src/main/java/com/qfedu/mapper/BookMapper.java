package com.qfedu.mapper;

import com.qfedu.common.vo.PageVo;
import com.qfedu.pojo.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert (Book record);
    //增加图书
    int insertSelective (Book record);
    //根据id查询某一本图书的详细信息
    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective (Book record);
    //根据id修改某一本图书的信息
    int updateByPrimaryKey (Book record);

    //根据书名查询图书
    Book selectByName(String bookname);

    //根据类型查询某一类图书
    PageVo<Book> seleckByType(int typeid);

    //根据风格查询查询某一类图书
    PageVo<Book> selectByTagOne(int TagOne);

    //根据流派查询查询某一类图书
    PageVo<Book> selectByTagTwo(int TagTwo);

    //根据元素查询查询某一类图书
    PageVo<Book> selectByTagThree(int TagThree);


}