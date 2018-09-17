package com.qfedu.pojo;

public class Consume {
    private Integer id;

    private Integer consumenumber;

    private String consumename;

    private Integer uid;

    private Integer bookid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsumenumber() {
        return consumenumber;
    }

    public void setConsumenumber(Integer consumenumber) {
        this.consumenumber = consumenumber;
    }

    public String getConsumename() {
        return consumename;
    }

    public void setConsumename(String consumename) {
        this.consumename = consumename == null ? null : consumename.trim();
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
}