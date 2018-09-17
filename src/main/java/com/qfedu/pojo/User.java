package com.qfedu.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String nickname;

    private String password;

    private String phone;

    private Integer flag;

    private Date createtime;

    private Date lastsingin;

    private Integer sigindays;

    private Integer score;

    private String headimg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastsingin() {
        return lastsingin;
    }

    public void setLastsingin(Date lastsingin) {
        this.lastsingin = lastsingin;
    }

    public Integer getSigindays() {
        return sigindays;
    }

    public void setSigindays(Integer sigindays) {
        this.sigindays = sigindays;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }
}