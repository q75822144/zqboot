package com.zqboot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zhouquan on 2016/3/8.
 * 获取常用第三方配置工具
 */
public class ThirdPartConfigUtil {


    public static String getRegByName(String name) {
        Properties properties = new Properties();
        InputStream in = ThirdPartConfigUtil.class.getResourceAsStream("/thirdPartConfig.properties");
        try {
            properties.load(new InputStreamReader(in, "utf-8"));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(name);
    }

    public static void main(String[] args) {
//        String s = null;
        System.out.println(getRegByName("test"));
    }
}
