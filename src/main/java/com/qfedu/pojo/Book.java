package com.qfedu.pojo;

import java.util.List;

public class Book {
    private Integer id;

    private String name;

    private Integer auid;

    private Integer typeid;

    private String status;

    private String expense;

    private Integer wordnum;

    private Integer monthticket;

    public Integer getMonthticket() {
        return monthticket;
    }

    public void setMonthticket(Integer monthticket) {
        this.monthticket = monthticket;
    }

    private int flag;

    public List<Bookimg> getBookimg() {
        return bookimg;
    }

    public void setBookimg(List<Bookimg> bookimg) {
        this.bookimg = bookimg;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private String info;

    private Author author;

    private List<Bookimg> bookimg;

    private List<Type> type;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense == null ? null : expense.trim();
    }

    public Integer getWordnum() {
        return wordnum;
    }

    public void setWordnum(Integer wordnum) {
        this.wordnum = wordnum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}