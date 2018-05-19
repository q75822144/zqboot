package com.zqboot.utils.datasource;

import com.zqboot.config.DataSourceConfig;
import com.zqboot.constant.DataSourceType;
import com.zqboot.utils.SpringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouquan on 2018/4/11.
 */
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@MapperScan(basePackages = "com.zqboot.interfaces.*.dao")
public class MybatisConfiguration {
    @Value("${mybatis.mapperLocations}")
    private org.springframework.core.io.Resource[] mapperLocations;

    //    @Value("${datasource.readSize}")
//    private String dataSourceSize;
    @Resource(name = "writeDataSource")
    private DataSource dataSource;
    @Resource(name = "readDataSources")
    private List<DataSource> readDataSources;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(roundRobinDataSouceProxy());
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 有多少个数据源就要配置多少个bean
     *
     * @return
     */
    @Bean(name="roundRobinDataSourceProxy")
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
//        int size = Integer.parseInt(dataSourceSize);
//        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);
        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // DataSource writeDataSource = SpringContextHolder.getBean("writeDataSource");
        // 写
        targetDataSources.put(DataSourceType.write.getType(), dataSource);
        targetDataSources.put(DataSourceType.read.getType(), readDataSources.get(0));
        //多个读数据库时
//        for (int i = 0; i < size; i++) {
//            targetDataSources.put(i, readDataSources.get(i));
//        }
        proxy.setDefaultTargetDataSource(dataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager((DataSource) SpringUtils.getBeanByName("roundRobinDataSourceProxy"));
    }
}
