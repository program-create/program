package com.qfedu.mapper;

import com.qfedu.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<Map<String ,Object>> selectByType(@Param("typeid") int typeid ,@Param("index") int index,@Param("page") int page);

    //查询某一类型的图书数量
    int selectcounttype(int typeid);
    //查询某一类风格的图书数量
    int selectcountstyle(int styleid);
    //查询某一类流派的图书数量
    int selectcountschools(int schoolsid);
    //查询莫一类元素的图书数量
    int selectcountelement(int elementid);

    //根据风格查询查询某一类图书
    List<Map<String ,Object>> selectByTagOne(@Param("styleid") int styleid ,@Param("index") int index,@Param("page") int page);

    //根据流派查询查询某一类图书
    List<Map<String ,Object>> selectByTagTwo(@Param("schoolsid") int schoolsid ,@Param("index") int index,@Param("page") int page);

    //根据元素查询查询某一类图书
    List<Map<String ,Object>> selectByTagThree(@Param("elementid") int elementid ,@Param("index") int index,@Param("page") int page);

    int updateMonthticket(@Param("bookid") int bookid ,@Param("monthticket") int monthticket);

    //查询一个图书的月票的数量
    int selectMonthticket(int id);

}