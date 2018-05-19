package com.zqboot.interfaces.user.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by zhouquan on 2017/11/13.
 */
public class User implements Serializable {

    @Expose
    private Integer id;
    private String name;
    private String account;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
