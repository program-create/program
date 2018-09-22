package com.qfedu.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.common.vo.ReViewVo;
import com.qfedu.mapper.ReviewMapper;
import com.qfedu.pojo.Review;
import com.qfedu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    //保存我的书评
    @Override
    public R save(Review review) {
        int i = reviewMapper.insert(review);
        return i>0?R.ok():R.error();
    }

    @Override
    public R listReview(int uid) {

            List<ReViewVo> list = reviewMapper.selectByUid(uid);
            if (list!=null&&list.size()>0){
                return R.res(1,"我的书评",list);
            }
        System.out.println(list.get(0).getContent());
            return R.res(0,"没有书评",null);
    }

    @Override
    public R delReview(int id) {
        int i = reviewMapper.deleteByPrimaryKey(id);
        return i>0?R.ok():R.error();
    }
}
