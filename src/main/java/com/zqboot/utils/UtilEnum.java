package com.zqboot.utils;

/**
 * Created by zhouquan on 2018/1/2.
 */
public class UtilEnum {

    /**
     * 常用时间格式化输出枚举值注册
     */
    public enum DateFormatString {
        yyyy_MM_dd("yyyy-MM-dd"),yyyy_MM_dd_HHmm("yyyy-MM-dd HH:mm"),
        yyyy_MM_dd_HHmmSS("yyyy-MM-dd HH:mm:ss"),yyyy_MM_dd_HHmm_chinese("yyyy年MM月dd日 HH:mm"),
        yyyyMMdd("yyyyMMdd"),yyMMddHHmmssSSS("yyMMddHHmmssSSS"),yyyyMMddHHmmssSSS("yyyyMMddHHmmssSSS"),
        yyyy_MM_dd_HHmmssSSS("yyyy-MM-dd HH:mm:ss.SSS");
        private String value;

        DateFormatString(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
