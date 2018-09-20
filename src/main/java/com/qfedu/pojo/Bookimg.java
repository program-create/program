package com.qfedu.pojo;

public class Bookimg {
    private Integer id;

    private String bookimages;

    private Integer bookid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookimg() {
        return bookimages;
    }

    public void setBookimg(String bookimg) {
        this.bookimages = bookimg == null ? null : bookimages.trim();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}