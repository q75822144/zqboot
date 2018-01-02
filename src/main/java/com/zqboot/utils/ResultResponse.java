package com.zqboot.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouquan on 2016/3/1.
 * 后端回写工具类
 */
public class ResultResponse implements Serializable {
    private boolean result;
    private String msg;
    private Map data = new HashMap();
    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 增加回写数据
     *
     * @param key
     * @param value
     */
    public void push(String key, Object value) {
        data.put(key, value);
    }

    /**
     * 普通回写
     *
     * @param response
     */
    public void write(HttpServletResponse response) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 带过滤器普通回写
     *
     * @param response
     */
    public void writeStrategy(HttpServletResponse response, ExclusionStrategy... exclusionStrategies) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setExclusionStrategies(exclusionStrategies);
            Gson gson = gsonBuilder.create();
            out.print(gson.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 年月日格式化输出json回写
     *
     * @param response
     */
    public void writeDateFormat(HttpServletResponse response, String dateFormat) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Gson gsonYMD = new GsonBuilder().setDateFormat(dateFormat).create();
            out.print(gsonYMD.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 年月日格式化并且指定过滤器输出json回写
     *
     * @param response
     */
    public void writeDateFormatAndStrategy(HttpServletResponse response, String dateFormat, ExclusionStrategy... exclusionStrategies) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Gson gsonYMD = new GsonBuilder().setDateFormat(dateFormat).setExclusionStrategies(exclusionStrategies).create();
            out.print(gsonYMD.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 时间戳格式化输出json回写
     *
     * @param response
     */
    public void writeTimeLong(HttpServletResponse response) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Gson gsonLong = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG).create();
            out.print(gsonLong.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
