package com.qfedu.pojo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class Monthticket {
    private Integer id;

    private Integer bookid;

    private Date votetime;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    private Integer votenum;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getVotetime() {
        return votetime;
    }

    public void setVotetime(Date votetime) {
        this.votetime = votetime;
    }

    public Integer getVotenum() {
        return votenum;
    }

    public void setVotenum(Integer votenum) {
        this.votenum = votenum;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Monthticket{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", votetime=" + votetime +
                ", votenum=" + votenum +
                ", uid=" + uid +
                '}';
    }
}