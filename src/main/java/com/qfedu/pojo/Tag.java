package com.qfedu.pojo;

public class Tag {
    private Integer id;

    private Integer taglistid;

    private String tagname;

    private Integer auid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaglistid() {
        return taglistid;
    }

    public void setTaglistid(Integer taglistid) {
        this.taglistid = taglistid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }
}