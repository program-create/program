package com.qfedu.common.vo;

import java.util.List;
import java.util.Map;

public class PageVo<T> {
    private int code;
    private String msg;
    private int count;
    private List<Map<String,Object>> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public static <T> PageVo<T> createPage(List<Map<String,Object>> data, int count){
        PageVo<T> pageVo=new PageVo<>();
        pageVo.setCode(0);
        pageVo.setMsg("查询结果成功");
        pageVo.setCount(count);
        pageVo.setData(data);
        return pageVo;
    }
}
