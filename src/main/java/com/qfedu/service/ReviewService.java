package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Review;

public interface ReviewService {
   R save(Review review);

   R listReview(int uid);

   R delReview(int id);
}
