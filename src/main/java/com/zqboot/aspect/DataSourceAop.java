package com.zqboot.aspect;

import com.zqboot.utils.datasource.DataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhouquan on 2018/4/11.
 */
@Aspect
@Component
public class DataSourceAop {

    private final static Logger log = LoggerFactory.getLogger(DataSourceAop.class);

    @Before("execution(* com.zqboot.interfaces.*.service.*.select*(..)) " +
            "|| execution(* com.zqboot.interfaces.*.service.*.get*(..)) " +
            "|| execution(* com.zqboot.interfaces.*.service.*.list*(..)) " +
            "|| execution(* com.zqboot.interfaces.*.service.*.find*(..)) " +
            "|| execution(* com.zqboot.interfaces.*.service.*.count*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.info("now dataSource is =========> Read");
    }

    @Before("execution(* com.zqboot.interfaces.*.service.*.save*(..))" +
            "|| execution(* com.zqboot.interfaces.*.service.*.add*(..))" +
            "|| execution(* com.zqboot.interfaces.*.service.*.remove*(..))" +
            "|| execution(* com.zqboot.interfaces.*.service.*.delete*(..))" +
            "|| execution(* com.zqboot.interfaces.*.service.*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.info("now dataSource is =========> Write");
    }
}
