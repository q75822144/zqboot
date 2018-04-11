package com.zqboot.utils.datasource;

import com.zqboot.constant.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by zhouquan on 2018/4/11.
 */
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {
//    private final int dataSourceNumber;
//    private AtomicInteger count = new AtomicInteger(0);
//
//    public MyAbstractRoutingDataSource(int dataSourceNumber) {
//        this.dataSourceNumber = dataSourceNumber;
//    }

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getJdbcType();
        if (null == typeKey || typeKey.equals(DataSourceType.write.getType())) {
            return DataSourceType.write.getType();
        } else {
            return DataSourceType.read.getType();
        }
        // 读 简单负载均衡
//        int number = count.getAndAdd(1);
//        int lookupKey = number % dataSourceNumber;
//        return new Integer(lookupKey);
    }
}
