package com.zqboot.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by zhouquan on 2017/3/16.
 */
public class DateDeserializer implements JsonSerializer<Date> {

    /**
     * 实体转json将时间格式化为时间戳类型
     * @param src
     * @param typeOfSrc
     * @param context
     * @return
     */
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTime());
    }
}