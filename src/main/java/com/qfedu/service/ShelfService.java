package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Shelf;

import java.util.List;

public interface ShelfService {
    R save(Shelf shelf);

    R listShelf(int uid);

    R delShelf(String[] arr);
}
