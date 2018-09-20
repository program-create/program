package com.qfedu.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.common.vo.ShelfVo;
import com.qfedu.mapper.MarkMapper;
import com.qfedu.pojo.Mark;
import com.qfedu.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkMapper markMapper;
    //添加到的书签
    @Override
    public R save(Mark mark) {
        int i = markMapper.insert(mark);
        return R.ok();
    }

    @Override
    public R listMark(int uid) {
        if (uid>0){
            List<ShelfVo> data = markMapper.selectByUid(uid);
            return R.res(1,"展示我的书签",data);
        }
       return R.res(0,"没有书签",null);
    }

    @Override
    public R delMark(String[] arr) {
        List list = new ArrayList();
        if (arr!=null&&arr.length>0){
            for (int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            int i = markMapper.deleteById(list);
            return i>0?R.ok():R.error();
        }
        return R.error();
    }
}
