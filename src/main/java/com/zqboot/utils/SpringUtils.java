package com.zqboot.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.lang.annotation.Annotation;
import java.util.Map;

public class SpringUtils {

	public static Object getSpringBean(Class<?> requiredType){
		 ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		 if(context == null){
			context = (ApplicationContext) new ClassPathXmlApplicationContext("spring-common.xml");
		 }
		 return context.getBean(requiredType);
	}
	
	public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType){
	    ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
	    if(context == null){
            context = (ApplicationContext) new ClassPathXmlApplicationContext("spring-common.xml");
         }
        return context.getBeansWithAnnotation(annotationType);
	}
	

}
