package com.zqboot.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by zhouquan on 2017/9/19.
 */
public class DbcontextHolder extends AbstractRoutingDataSource {

    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置当前数据源
     * @param dbType
     */
    public static void setDbType(String dbType){
        contextHolder.set(dbType);
    }
    /**
     * 获得当前数据源
     * @return
     */
    public static String getDbType(){
        String dbType = (String)contextHolder.get();
        return dbType;
    }
    /**
     *清除上下文
     *
     */
    public void clearContext(){
        contextHolder.remove();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return DbcontextHolder.getDbType();
    }
}
