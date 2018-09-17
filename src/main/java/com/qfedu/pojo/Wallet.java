package com.qfedu.pojo;

import java.util.Date;

public class Wallet {
    private Integer id;

    private Integer uid;

    private Integer money;

    private Integer monthticket;

    private Integer recharge;

    private Date rechargetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMonthticket() {
        return monthticket;
    }

    public void setMonthticket(Integer monthticket) {
        this.monthticket = monthticket;
    }

    public Integer getRecharge() {
        return recharge;
    }

    public void setRecharge(Integer recharge) {
        this.recharge = recharge;
    }

    public Date getRechargetime() {
        return rechargetime;
    }

    public void setRechargetime(Date rechargetime) {
        this.rechargetime = rechargetime;
    }
}