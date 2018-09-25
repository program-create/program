package com.qfedu.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.mapper.WalletMapper;
import com.qfedu.pojo.Wallet;
import com.qfedu.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Administrator
 * @Date 2018/9/21 0021 21:33
 */

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletMapper mapper;

    @Override
    public R selectByUid (int uid) {
        Wallet wallet = mapper.selectByUid(uid);
        if (wallet != null) {
            return new R(0, "获取钱包成功", wallet);
        } else {
            return R.error();
        }
    }

    @Override
    public R updateXXCoin (int money, int uid) {
        int i = mapper.updateXXCoin(money, uid);
        if (i>0){
            return R.ok();
        } else {
            return R.error();
        }
    }


}
