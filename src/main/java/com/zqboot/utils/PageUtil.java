package com.zqboot.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by zhouquan on 2016/3/17.
 * 分页工具
 */
public class PageUtil extends HashMap<String, Object> {

    /**
     * 当前页码
     */
    public static final String PAGE = "page";
    /**
     * 每页条数
     */
    public static final String SIZE = "size";
    /**
     * 总记录数
     */
    public static final String TOTAL = "total";
    /**
     * 分页开始位置
     */
    public static final String START = "start";

    public PageUtil() {

    }

    /**
     * 分页查询
     *
     * @param request
     */
    public PageUtil(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = String.valueOf(e.nextElement());
            //放入分页需要用到的变量
            if (SIZE.equals(key) || PAGE.equals(key)) {
                Integer val = Integer.parseInt(request.getParameter(key));
                this.put(key, val);
            } else {
                String val = request.getParameter(key);
                this.put(key, val);
            }
        }
        if (get(SIZE) == null) {
            this.put(SIZE, 10);
        }
        if (get(PAGE) == null) {
            this.put(PAGE, 1);
        }
        Integer size = Integer.parseInt(get(SIZE).toString());
        Integer page = Integer.parseInt(get(PAGE).toString());
        Integer start = (page - 1) * size;
        this.put(START, start);
    }

    /**
     * 动态传入条件
     *
     * @param request
     * @param useFlag 构造器重载用，区分是否需要条件
     */
    public PageUtil(HttpServletRequest request, String useFlag) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = String.valueOf(e.nextElement());
            String val = request.getParameter(key);
            this.put(key, val);
        }
    }

}
