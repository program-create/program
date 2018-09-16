package com.qfedu.common.vo;

import java.util.List;

/*统一json结果类 非查询*/
public class RList<T> {
    private int code;
    private String msg;
    private List<T> datas;

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

    public List<T> getDatas () {
        return datas;
    }

    public void setDatas (List<T> datas) {
        this.datas = datas;
    }

    public RList () {
    }

    public RList (int code, String msg, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.datas = datas;
    }

    public static RList ok(){
        return new RList(0,"成功",null);
    }
    public static RList error(){
        return new RList(1,"失败",null);
    }
}
