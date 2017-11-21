package com.zqboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by zhouquan on 2017/11/13.
 */
@Aspect
//@Component
public class TransactionalAspect {

    @Before("execution(* com.zq.webserver.interfaces.*.service.*.*(..))")
    public void before(JoinPoint joinPoint) throws Exception {
        System.out.println(1111);
    }
}
