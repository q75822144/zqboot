package com.zqboot.exception;

/**
 * Created by zhouquan on 2018/4/4.
 */
public class BusinessException extends Exception {

    private int code;
    private String msg;

    public BusinessException() {
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
