package com.qfedu.common.vo;

/**
 * 作者信息修改Vo类
 */
public class AuthorVo {
    private int id;
    private String email;//邮箱
    private Integer qqnumber;//QQ号
    private String address;//住址
    private Integer postnumber;//邮编

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(Integer qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostnumber() {
        return postnumber;
    }

    public void setPostnumber(Integer postnumber) {
        this.postnumber = postnumber;
    }

    public AuthorVo() {
    }

    public AuthorVo(int id, String email, Integer qqnumber, String address, Integer postnumber) {
        this.id = id;
        this.email = email;
        this.qqnumber = qqnumber;
        this.address = address;
        this.postnumber = postnumber;
    }

    @Override
    public String toString() {
        return "AuthorVo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", qqnumber=" + qqnumber +
                ", address='" + address + '\'' +
                ", postnumber=" + postnumber +
                '}';
    }
}
