package com.qfedu.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.common.vo.ShelfVo;
import com.qfedu.mapper.ChapterMapper;
import com.qfedu.mapper.ShelfMapper;
import com.qfedu.pojo.Shelf;
import com.qfedu.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.HeaderParser;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    private ShelfMapper shelfMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    //向我的数据添加小说
    @Override
    public R save(Shelf shelf) {
        int i=0;
        try {
            //获取本书的最新章节的id
            int newchapterid = chapterMapper.selectMax(shelf.getBookid());
            shelf.setNewchaptername(newchapterid);
            i = shelfMapper.insert(shelf);
        }catch (Exception e){
            return R.error();
        }
        return i>0?R.ok():R.error();
    }

    //展示书架
    @Override
    public R listShelf(int uid) {
        try {
            List<ShelfVo> shelfList = shelfMapper.selectbyuid(uid);
            return R.res(1,"书架展示列表",shelfList);
        }catch (Exception e){
            return R.res(0,"没有添加任何小说",null);
        }
    }
    //删除书架中选中的书记
    @Override
    public R delShelf(String[] arr) {
        //判断传入的参数是否为空
        if (arr!=null&&arr.length>0){
            List list = new ArrayList();
            for (int i=0;i<arr.length;i++){
                  list.add(arr[i]);
            }
            System.out.println(list+"集合");
            int i = shelfMapper.deleteById(list);
            return i>0?R.ok():R.res(1,"书架中没有此书",null);
        }
        return R.error();
    }

}
