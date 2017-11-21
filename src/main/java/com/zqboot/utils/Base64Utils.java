package com.zqboot.utils;

import java.util.Base64;

/**
 * Created by zhouquan on 2017/9/28.
 */
public class Base64Utils {

    public static String encoderBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String decoderBase64(String str) {
        return new String(Base64.getDecoder().decode(str.getBytes()));
    }

    public static void main(String[] args) {
        String s = "jmadmin:" + Md5Util.makeMD5("a123456");
        String as = encoderBase64(s);
        System.out.println(as);

        System.out.println(decoderBase64(as));
        System.out.println(s.split(":")[0]);
    }
}
