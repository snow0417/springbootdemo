package com.example.demo.mybatis.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author xueyu
 * @date 2020/6/30 18:39
 */
public class RoutingDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.get();
    }
}
