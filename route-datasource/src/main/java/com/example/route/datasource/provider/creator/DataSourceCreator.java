package com.example.route.datasource.provider.creator;

import com.example.route.datasource.enums.DataSourceTypeEnum;
import com.example.route.datasource.properties.DynamicDataSourceProperties;

import javax.sql.DataSource;

/**
 * 数据源创建接口
 *
 * @author liugang
 * @create 2021/12/20
 */
public interface DataSourceCreator {

    /**
     * 根据配置创建数据源
     *
     * @param dataSourceProperty 数据源配置
     * @return
     */
    DataSource createDataSource(DynamicDataSourceProperties.DataSourceProperty dataSourceProperty);

    /**
     * 数据库类型
     *
     * @return
     */
    DataSourceTypeEnum dataSourceType();
}
