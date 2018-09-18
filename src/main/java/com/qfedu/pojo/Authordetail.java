package com.qfedu.pojo;

public class Authordetail {
    private Integer id;

    private Integer auid;

    private Integer idcard;

    private String address;

    private Integer postnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPostnumber() {
        return postnumber;
    }

    public void setPostnumber(Integer postnumber) {
        this.postnumber = postnumber;
    }
}