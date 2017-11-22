package com.zqboot.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * spring 获取实例工具类
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 通过名称在spring容器中获取实例对象
     *
     * @param beanName
     * @return
     */
    public static Object getBeanByName(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /**
     * 通过类型在spring容器中获取实例对象
     *
     * @param cls
     * @return
     */
    public static <T> T getBeanByType(Class<T> cls) {
        return (T) applicationContext.getBean(cls);
    }

    /**
     * 通过类型在spring容器中获取实例对象的map集合
     *
     * @param cls
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> cls) {
        return applicationContext.getBeansOfType(cls);
    }


}
