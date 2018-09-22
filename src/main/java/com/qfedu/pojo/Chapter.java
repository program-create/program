package com.qfedu.pojo;

public class Chapter {
    private Integer id;

    private Integer bookid;

    private String chaptername;

    private Integer flag;

    private String chaptercontent;

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

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername == null ? null : chaptername.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getChaptercontent() {
        return chaptercontent;
    }

    public void setChaptercontent(String chaptercontent) {
        this.chaptercontent = chaptercontent == null ? null : chaptercontent.trim();
    }
}