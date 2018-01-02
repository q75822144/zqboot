package com.zqboot.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;

/**
 * Created by zhouquan on 2018/1/2.
 */
public class SimpleStrategyFilter implements ExclusionStrategy {

    /**
     * 单例实例化内部类
     * 懒汉式（避免资源浪费）、线程安全、代码简单。因为java机制规定，
     * 内部类SingletonHolder只有在getInstance()方法第一次调用的时候才会被加载（实现了lazy），
     * 而且其加载过程是线程安全的（实现线程安全）。内部类加载的时候实例化一次instance
     */
    private static class SingletonHolder {
        private static final SimpleStrategyFilter INSTANCE = new SimpleStrategyFilter();
    }

    public static final SimpleStrategyFilter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private SimpleStrategyFilter() {
    }

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getAnnotation(Expose.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
