package com.example.route.datasource.provider.creator;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.route.datasource.enums.DataSourceTypeEnum;
import com.example.route.datasource.properties.DynamicDataSourceProperties;

import javax.sql.DataSource;

/**
 * druidDataSource创建类
 *
 * @author liugang
 * @create 2021/12/20
 */
public class DruidDataSourceCreator implements DataSourceCreator {

    @Override
    public DataSource createDataSource(DynamicDataSourceProperties.DataSourceProperty dataSourceProperty) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceProperty.getUrl());
        druidDataSource.setUsername(dataSourceProperty.getUsername());
        druidDataSource.setPassword(dataSourceProperty.getPassword());
        druidDataSource.setDriverClassName(dataSourceProperty.getDriverClassName());
        return druidDataSource;
    }

    @Override
    public DataSourceTypeEnum dataSourceType() {
        return DataSourceTypeEnum.MASTER;
    }
}
