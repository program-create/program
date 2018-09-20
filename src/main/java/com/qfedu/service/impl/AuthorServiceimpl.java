package com.qfedu.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.redis.JedisUtil;
import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.ALiYunNote;
import com.qfedu.common.util.CookieUtil;
import com.qfedu.common.util.EncrypUtil;
import com.qfedu.common.util.ShiroEncryUtil;
import com.qfedu.common.vo.R;
import com.qfedu.mapper.AuthorMapper;
import com.qfedu.pojo.Author;
import com.qfedu.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class AuthorServiceimpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private RedisUtil redisUtil;

    //作者注册
    @Override
    public R save(Author author,int args) {
        if (author != null) {
            String phone = author.getPhone();
            //查看验证码是否失效
            if (redisUtil.hasKey(phone)) {
                //查询出Redis中的验证码
                String args1 = (String) redisUtil.get(phone);
                if (Objects.equals(args, args1)) {
                    //加密密码在存入数据库
                    author.setPassword(ShiroEncryUtil.md5(author.getPassword()));
                    authorMapper.save(author);
                    return R.ok();
                }
                return new R(1, "验证码不一致", null);
            }
            return new R(1, "验证码已失效", null);
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
    public R authorLogin(String nickname, String password, HttpServletResponse response) {
        //1、查询数据库
        Author author = authorMapper.queryByNickName(nickname);
        System.out.println("用户信息："+author);
        //2、验证登陆信息
        if (author != null) {
            //用户存在
            if (Objects.equals(author.getPassword(), ShiroEncryUtil.md5(password))) {
                //登录成功
                //3、生成令牌--唯一，复杂，密文
                String token = EncrypUtil.md5Pass(author.getId().toString(), nickname);
                //4、存储登陆信息到Redis
                redisUtil.set(token,author, 60*30);
                //5、令牌记录到Cookie
                CookieUtil.setCK(response, "token", token);
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
        if (redisUtil.hasKey(token)) {
            //有效--读取Redis中的用户信息
            String json = (String) redisUtil.get(token);
            //重新设置时间
            redisUtil.expire(token, 30*60);
            return new R(0, "OK", JSON.parseObject(json, Author.class));
        } else {
            return new R(0, "token已失效", null);
        }
    }

    //注销
    @Override
    public R loginOut(String token) {
        //删除Redis
        redisUtil.del(token);
        return R.ok();
    }
}
