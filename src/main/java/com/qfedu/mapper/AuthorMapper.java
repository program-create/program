package com.qfedu.mapper;

import com.qfedu.common.vo.AuthorVo;
import com.qfedu.pojo.Author;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {

    //作者表信息添加--作者注册
    int save(Author record);

    //根据作者名查询作者信息
    Author queryByNickName(String nickname);

    //通过作者ID修改作者表信息
    int updateAuthor(AuthorVo authorVo);

    //通过作者名修改密码--忘记密码 第三步
    int updateByNickName(@Param("nickname") String nickname, @Param("password") String password);

    //通过作者ID修改作者头像
    int updateHeadimg(Author author);

}