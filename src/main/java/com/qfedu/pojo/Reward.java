package com.qfedu.pojo;

import java.util.Date;

public class Reward {
    private Integer id;

    private Integer bookid;

    private Integer propid;

    private Integer propnum;

    private Integer money;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getPropid() {
        return propid;
    }

    public void setPropid(Integer propid) {
        this.propid = propid;
    }

    public Integer getPropnum() {
        return propnum;
    }

    public void setPropnum(Integer propnum) {
        this.propnum = propnum;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}