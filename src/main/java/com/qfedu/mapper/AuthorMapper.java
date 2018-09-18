package com.qfedu.mapper;

import com.qfedu.pojo.Author;

public interface AuthorMapper {
    int deleteByPrimaryKey (Integer id);

    //作者信息添加
    int save (Author record);

    int insertSelective (Author record);

    Author selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Author record);

    //通过作者名修改作者信息
    int updateById (String nickname);

    //根据作者名查询作者信息
    Author queryByNickName(String nickname);
}