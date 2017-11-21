package com.zqboot.utils;

import java.util.Date;
import java.util.Random;

/**
 * Created by zhouquan on 2016/3/11.
 */
public class RandomCode {
    private static final Random r = new Random();

    public static String getPicture() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.ORDER_RANDOM.charAt(r.nextInt(62)));
        sb.append(new Date().getTime());
        return sb.toString();
    }

    public static String getNonce_str() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(Constants.ORDER_RANDOM.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }

    public static String getCheckCode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(Constants.ORDER_RANDOM.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }

    public static String getVerifyCode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(Constants.RANDOM_NUMBER.charAt(r.nextInt(9)));
        }
        return sb.toString();
    }

    public static String getRanDomCode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(Constants.RANDOM_NUMBER.charAt(r.nextInt(9)));
        }
        return sb.toString();
    }

    public static String getMobileTransid(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(Constants.RANDOM_NUMBER.charAt(r.nextInt(9)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getNonce_str());
    }

}
