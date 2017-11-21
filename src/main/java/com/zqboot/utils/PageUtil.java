package com.zqboot.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by zhouquan on 2016/3/17.
 */
public class PageUtil extends HashMap {

//    private Integer size;   //每页记录条数
//    private Integer page;    //当前页码
//    private Integer totalRecord;    //总记录数
//    private Integer start;  //limit开始位置

    public PageUtil() {

    }

    /**
     * 分页查询
     * @param request
     */
    public PageUtil(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = String.valueOf(e.nextElement());
            //放入分页需要用到的变量
            if ("size".equals(key) || "page".equals(key)) {
                Integer val = Integer.parseInt(request.getParameter(key));
                this.put(key, val);
            } else {
                String val = request.getParameter(key);
                this.put(key, val);
            }
        }
        if (get("size") == null) {
            this.put("size", 10);
        }
        if (get("page") == null) {
            this.put("page", 1);
        }
        Integer size = Integer.parseInt(get("size").toString());
        Integer page = Integer.parseInt(get("page").toString());
        Integer start = (page - 1) * size;
        this.put("start", start);
    }

    /**
     * 动态传入条件
     * @param request
     * @param useFlag
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
