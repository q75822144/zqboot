package com.zqboot.utils;

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
 */
public class ResultResponse implements Serializable{
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

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public void push(String key, Object value, String useFilter) {
        Class c = value.getClass();
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            if (f.getAnnotation(FilterAnnotion.class) != null) {
                for (String s : f.getAnnotation(FilterAnnotion.class).isDelete()) {
                    if (s.equals(useFilter)) {
                        f.setAccessible(true);
                        try {
                            f.set(value, null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        data.put(key, value);
    }

    public void push(String key, Object value) {
        data.put(key, value);
    }

    public void push(String name, List list, String useFilter) throws IllegalAccessException {
        if (list != null && list.size() > 0) {
            for (Object o : list) {
                Class c = o.getClass();
                Field[] fs = c.getDeclaredFields();
                for (Field f : fs) {
                    if (f.getAnnotation(FilterAnnotion.class) != null) {
                        for (String s : f.getAnnotation(FilterAnnotion.class).isDelete()) {
                            if (s.equals(useFilter)) {
                                f.setAccessible(true);
                                f.set(o, null);
                            }
                        }
                    }

                }
            }
            data.put(name, list);
        }
    }

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
     * 年月日格式化输出json
     *
     * @param response
     */
    public void writeYYYYMMDD(HttpServletResponse response) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Gson gsonYMD = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            out.print(gsonYMD.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 年月日格式化输出json
     *
     * @param response
     */
    public void writeYYYYMMDD_HHMM(HttpServletResponse response) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Gson gsonYMD = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
            out.print(gsonYMD.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 年月日时分秒格式化输出json
     *
     * @param response
     */
    public void writeYYYYMMDD_HHMMSS(HttpServletResponse response) {
        //设置数据返回类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Gson gsonYMDHMS = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            out.print(gsonYMDHMS.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 时间戳格式化输出json
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
