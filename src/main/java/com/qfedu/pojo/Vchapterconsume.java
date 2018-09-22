package com.qfedu.pojo;

import java.util.Date;

public class Vchapterconsume {
    private Integer id;

    private Integer chapteid;

    private Integer uid;

    private Integer money;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapteid() {
        return chapteid;
    }

    public void setChapteid(Integer chapteid) {
        this.chapteid = chapteid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}