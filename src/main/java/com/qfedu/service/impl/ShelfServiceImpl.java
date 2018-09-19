package com.qfedu.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.mapper.ChapterMapper;
import com.qfedu.mapper.ShelfMapper;
import com.qfedu.pojo.Shelf;
import com.qfedu.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.HeaderParser;

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
}
