package com.zqboot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zhouquan on 2016/3/8.
 */
//定义所有的正则表达式，常量形势
public class RegUtils {


    public static String getRegByName(String name){
        Properties properties = new Properties();
        InputStream in = RegUtils.class.getResourceAsStream("/regs.properties");
        try {
            properties.load(new InputStreamReader(in,"utf-8"));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(name);
    }

    public static int getIntRegByName(String name){
        Properties properties = new Properties();
        InputStream in = RegUtils.class.getResourceAsStream("/regs.properties");
        try {
            properties.load(new InputStreamReader(in,"utf-8"));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(properties.getProperty(name));
    }

//    public static void main(String[] args) {
//        String s = null;
//        System.out.println(getRegByName("test"));
//    }
}
