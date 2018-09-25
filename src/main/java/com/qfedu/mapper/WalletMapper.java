package com.qfedu.mapper;

import com.qfedu.pojo.Wallet;
import org.apache.ibatis.annotations.Param;

public interface WalletMapper {
    int deleteByPrimaryKey (Integer id);
    int insert (Wallet record);
    int insertSelective (Wallet record);
    Wallet selectByPrimaryKey (Integer id);
    int updateByPrimaryKeySelective (Wallet record);
    int updateByPrimaryKey (Wallet record);

    //赠送月票后减少月票
    int updateMonthticket (@Param("id") int id, @Param("monthticket") int monthticket);
    //查询用户月票数量
    int selectMonthticket (int uid);
    //    我的钱包
    Wallet selectByUid (int uid);
    //奖励潇湘币
    int updateXXCoin (@Param("money") int money, @Param("uid") int uid);
//    充值潇湘币


}