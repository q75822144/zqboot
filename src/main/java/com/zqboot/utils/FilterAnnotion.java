package com.zqboot.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhouquan on 2015/9/21.
 * 自定义实体过滤器
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterAnnotion {

    String[] isDelete() default {"isDelete"};

}
