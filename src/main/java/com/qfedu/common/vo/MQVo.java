package com.qfedu.common.vo;

/**
 * @Author Administrator
 * @Date 2018/9/26 0026 16:40
 */
public class MQVo<T> {
    private Integer code;
    private Integer scores;
    private Integer id;

    public Integer getCode () {
        return code;
    }

    public void setCode (Integer code) {
        this.code = code;
    }

    public Integer getScores () {
        return scores;
    }

    public void setScores (Integer scores) {
        this.scores = scores;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public MQVo (Integer code, Integer scores, Integer id) {

        this.code = code;
        this.scores = scores;
        this.id = id;
    }

    public MQVo () {

    }
}
