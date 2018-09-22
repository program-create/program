package com.qfedu.mapper;

import com.qfedu.common.vo.AuthorVo;
import com.qfedu.pojo.Authordetail;
import org.apache.ibatis.annotations.Param;

public interface AuthordetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authordetail record);

    int insertSelective(Authordetail record);

    Authordetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authordetail record);

    int updateByPrimaryKey(Authordetail record);

    //通过作者ID修改作者详情表信息
    int updateAuthorDatail(AuthorVo authorVo);

    //通过作者ID查询身份证是否存在--忘记密码 第一步
    String queryById(int id);

}