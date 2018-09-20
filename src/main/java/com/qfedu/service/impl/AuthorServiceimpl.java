package com.qfedu.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.redis.JedisUtil;
import com.qfedu.common.util.EncrypUtil;
import com.qfedu.common.vo.R;
import com.qfedu.mapper.AuthorMapper;
import com.qfedu.pojo.Author;
import com.qfedu.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class AuthorServiceimpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private JedisUtil jedisUtil;

    //作者信息添加
    @Override
    public R save(Author record) {
        if (record != null) {
            authorMapper.save(record);
            return R.ok();
        }
        return R.error();
    }

    //通过作者名修改作者信息
    @Override
    public R updateById(String nickname) {
        return null;
    }

    //登陆
    @Override
    public R authorLogin(String nickname, String password) {
        //1、查询数据库
        Author author = authorMapper.queryByNickName(nickname);
        //2、验证登陆信息
        if (author != null) {
            //用户存在
            if (Objects.equals(author.getPassword(), password)) {
                //登录成功
                //3、生成令牌--唯一，复杂，密文
                String token = EncrypUtil.md5Pass(author.getId().toString(), nickname);
                //4、存储登陆信息到Redis
                jedisUtil.addStr(token, JSON.toJSONString(author), TimeUnit.MINUTES, 30);
                //5、令牌记录到Cookie---控制器(在Controller层)
                return new R(0, "登陆成功", token);
            }
            return new R(1, "密码错误", null);
        } else {
            return new R(1, "用户不存在",null);
        }
    }

    //登陆时token已存在
    @Override
    public R loginCheck(String token) {
        //判断该token是否存在
        if (jedisUtil.isKey(token)) {
            //有效--读取Redis中的用户信息
            String json = jedisUtil.getStr(token);
            //重新设置时间
            jedisUtil.expire(token, TimeUnit.MINUTES, 30);
            return new R(0, "OK", JSON.parseObject(json, Author.class));
        } else {
            return R.error();
        }
    }

    //注销
    @Override
    public R loginOut(String token) {
        //删除Redis
        jedisUtil.delKey(token);
        return R.ok();
    }
}
