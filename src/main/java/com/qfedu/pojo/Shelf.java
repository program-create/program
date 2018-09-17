package com.qfedu.pojo;

import java.util.Date;

public class Shelf {
    private Integer id;

    private Integer uid;

    private Integer bookid;

    private Integer newchaptername;

    private Date createdate;

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

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getNewchaptername() {
        return newchaptername;
    }

    public void setNewchaptername(Integer newchaptername) {
        this.newchaptername = newchaptername;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}