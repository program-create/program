package com.qfedu.common.vo;

/*统一json结果类 非查询*/
public class R {
    private int code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public R () {
    }

    public R (int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }
    public static R ok(){
        return new R(0,"成功",null);
    }
    public static R error(){
        return new R(1,"失败",null);
    }
}
