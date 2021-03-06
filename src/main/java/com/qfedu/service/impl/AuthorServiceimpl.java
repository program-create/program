package com.qfedu.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.util.*;
import com.qfedu.common.vo.AuthorVo;
import com.qfedu.common.vo.R;
import com.qfedu.mapper.AuthorMapper;
import com.qfedu.mapper.AuthordetailMapper;
import com.qfedu.pojo.Author;
import com.qfedu.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Objects;

@Service
public class AuthorServiceimpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private AuthordetailMapper authordetailMapper;
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
                    if (authorMapper.queryByNickName(author.getNickname()) == null) {
                        //加密密码在存入数据库
                        author.setPassword(ShiroEncryUtil.md5(author.getPassword()));
                        if (authorMapper.save(author) > 0) {
                            return R.ok();
                        }
                        return new R(1001,"注册失败",null);
                    }
                    return new R(1002,"作者名已被占用",null);
                }
                return new R(1003, "验证码不一致", null);
            }
            return new R(1004, "验证码已失效", null);
        }
        return R.error();
    }

    //通过令牌获取Redis中作者ID修改作者表信息
    @Override
    public R updateAuthor(AuthorVo authorVo, HttpServletRequest request) {
        //获取token
        String token = TokenTool.getToken(request);
        if (token != null) {
            //从获取Redis用户信息
            Author author = (Author) redisUtil.get(token);
            if (author != null) {
                authorVo.setId(author.getId());
                if (authorMapper.updateAuthor(authorVo) > 0  ) {
                    System.out.println("作者表");
                    if (authordetailMapper.updateAuthorDatail(authorVo) > 0) {
                        System.out.println("作者详情表");
                        //用户最新信息存入Redis并刷新令牌时间
                        redisUtil.set(token, authorMapper.queryByNickName(author.getNickname()), 30 * 60);
                        return R.ok();
                    }
                    return R.error();
                }
                return R.error();
            }
            return new R(1005, "token已失效", null);
        }
        return R.error();
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
                redisUtil.set(token,author, 30*60);
                //5、令牌记录到Cookie
                CookieUtil.setCK(response, "token", token);
                return new R(0001, "登陆成功", token);
            }
            return new R(1006, "密码错误", null);
        } else {
            return new R(1007, "用户不存在",null);
        }
    }

    //登陆时token已存在
    @Override
    public R loginCheck(HttpServletRequest request) {
        //获取token
        String token = TokenTool.getToken(request);
        if (token != null & token.length() > 0) {
            //判断该token是否存在
            if (redisUtil.hasKey(token)) {
                //有效--读取Redis中的用户信息
                String json = (String) redisUtil.get(token);
                //重新设置时间
                redisUtil.expire(token, 30*60);
                return new R(0002, "单点登陆验证成功", JSON.parseObject(json, Author.class));
            } else {
                return new R(1008, "token已失效", null);
            }
        }
        return new R(1009, "未登录", null);
    }

    //注销
    @Override
    public R loginOut(HttpServletRequest request) {
        //获取token
        String token = TokenTool.getToken(request);
        if (token != null & token.length() > 0) {
            //判断该token是否存在
            if (redisUtil.hasKey(token)) {
                //删除Redis
                redisUtil.del(token);
                return R.ok();
            } else {
                return new R(1008, "token已失效", null);
            }
        }
        return R.error();
    }

    //作者密码重置--忘记密码 第一步
    @Override
    public R updatePassword1(String nickname, String idcard) {
        //通过作者名查询作者id
        Author author = authorMapper.queryByNickName(nickname);
        if (author.getId() != 0) {
            String idcard1 = authordetailMapper.queryById(author.getId());
            if (idcard1 != null && idcard.length() > 0 && Objects.equals(idcard1,idcard)) {
                //验证成功返回手机号
                return new R(0003, "验证成功", author.getPhone());
            }
            return new R(1010, "身份证错误", null);
        }
        return new R(1011, "作者名错误", null);
    }

    //作者密码重置--忘记密码 第三步
    @Override
    public R updatePassword3(String nickname, String password) {
        if (authorMapper.updateByNickName(nickname, ShiroEncryUtil.md5(password)) > 0) {
            return R.ok();
        }
        return R.error();
    }

    //通过作者ID修改作者头像
    @Override
    public R updateHeadimg(String headimg, HttpServletRequest request) {
        //获取token
        String token = TokenTool.getToken(request);
        if (token != null) {
            System.out.println(1);
            //从获取Redis用户信息
            Author author = (Author) redisUtil.get(token);
            if (author != null) {
                System.out.println(2);
                author.setHeadimg(headimg);
                if (authorMapper.updateHeadimg(author) > 0  ) {
                    //用户最新信息存入Redis并刷新令牌时间
                    redisUtil.set(token, authorMapper.queryByNickName(author.getNickname()), 30 * 60);
                    return R.ok();
                }
                return R.error();
            }
            return new R(1008, "token已失效", null);
        }
        return R.error();
    }


}
