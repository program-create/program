package com.qfedu.service;

import com.qfedu.common.vo.R;
import com.qfedu.pojo.Wallet;

public interface WalletService {
    R selectByUid(int uid);

    R updateXXCoin(int money,int uid);
}
