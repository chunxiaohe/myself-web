package com.cc.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author He Chunxiao
 * @date 2019-03-13 14:27
 * @desc
 */
//@SpringBootConfiguration
@MapperScan(value = {"com.cc.back.**.mapper","com.cc.blog.**.mapper"})
public class DataSourceConfig extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        //return  DynamicDataSourceContextHolder.getDataSourceType();
        return null;
    }
}
