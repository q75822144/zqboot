package com.zqboot.utils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by zhouquan on 2016/3/29.
 * 实体类映射工具
 */
public class HttpUtils {

    /**
     * 从request中获取参数转化为实体类
     *
     * @param request
     * @param c
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T convert(HttpServletRequest request, Class<T> c) throws Exception {
        T bean = c.newInstance();
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = String.valueOf(e.nextElement());
            Method get = getMethod(c, key);
            Method set = null;
            if (get != null) {
                Class type = get.getReturnType();
                String val = request.getParameter(key);
                String setname = getSetMethodName(key);
                if (val != null) {
                    if ((type == Integer.class) || (type == Integer.TYPE)) {
                        set = c.getMethod(setname, new Class[]{Integer.class});
                        set.invoke(bean, new Object[]{Integer.valueOf(Integer.parseInt(val))});
                    } else if (type == Boolean.class) {
                        set = c.getMethod(setname, new Class[]{Boolean.class});
                        set.invoke(bean, new Object[]{Boolean.valueOf(Boolean.parseBoolean(val))});
                    } else if ((type == Timestamp.class) || (type == Time.class)) {
                        if (!"".equals(val)) {
                            Date date = TimeUtils.getTimeByString(val);
                            set = c.getMethod(setname, new Class[]{Timestamp.class});
                            set.invoke(bean, new Object[]{new Timestamp(date.getTime())});
                        }
                    } else if (type == Date.class) {
                        if (!"".equals(val)) {
                            Date date = TimeUtils.getTimeByString(val);
                            set = c.getMethod(setname, new Class[]{Date.class});
                            set.invoke(bean, date);
                        }
                    } else if ((type == Long.class) || (type == Long.TYPE)) {
                        set = c.getMethod(setname, new Class[]{Long.class});
                        set.invoke(bean, new Object[]{Long.valueOf(Long.parseLong(val))});
                    } else if ((type == Short.class) || (type == Short.TYPE)) {
                        set = c.getMethod(setname, new Class[]{Short.class});
                        set.invoke(bean, new Object[]{Short.valueOf(Short.parseShort(val))});
                    } else if ((type == Float.class) || (type == Float.TYPE)) {
                        set = c.getMethod(setname, new Class[]{Float.class});
                        set.invoke(bean, new Object[]{Float.valueOf(Float.parseFloat(val))});
                    } else if ((type == Double.class) || (type == Double.TYPE)) {
                        set = c.getMethod(setname, new Class[]{Double.class});
                        set.invoke(bean, new Object[]{Double.valueOf(Double.parseDouble(val))});
                    } else if (type == BigDecimal.class) {
                        set = c.getMethod(setname, new Class[]{BigDecimal.class});
                        set.invoke(bean, new BigDecimal(val));
                    } else if ((type == Byte.class) || (type == Byte.TYPE)) {
                        set = c.getMethod(setname, new Class[]{Byte.class});
                        set.invoke(bean, new Object[]{Byte.valueOf(Byte.parseByte(val))});
                    } else {
                        set = c.getMethod(setname, new Class[]{String.class});
                        set.invoke(bean, new Object[]{val});
                    }
                }
            }
        }
        return bean;
    }

    /**
     * 获取指定实体类的get方法
     *
     * @param c
     * @param key
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Method getMethod(Class<T> c, String key) {
        String method = "get";
        method = method + StringUtils.firstUpper(key);
        Method m = null;
        try {
            m = c.getDeclaredMethod(method);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    /**
     * 获取属性get方法名
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String getSetMethodName(String key) {
        String method = "set";
        method = method + StringUtils.firstUpper(key);
        return method;
    }

}
