package com.example.route.datasource.provider;


import cn.hutool.core.collection.CollUtil;
import com.example.route.datasource.properties.DynamicDataSourceProperties;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * yml配置数据源提供者
 *
 * @author liugang
 * @create 2021/12/20
 */
public class YmlDynamicDataSourceProvider extends AbstractDynamicDataSourceProvider {

    private Map<String, DynamicDataSourceProperties.DataSourceProperty> dataSourceConfig;

    public YmlDynamicDataSourceProvider(Map<String, DynamicDataSourceProperties.DataSourceProperty> dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    @Override
    public Map<String, DataSource> loadDataSources() {
        if (CollUtil.isEmpty(dataSourceConfig)) {
            throw new IllegalStateException("data source must not be null,check the config");
        }
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        // 根据不同的数据库创建不同的数据源
        dataSourceConfig.forEach((key, value) -> {
            DataSource dataSource = super.getDataSourceCreator(key).createDataSource(value);
            dataSourceMap.put(key, dataSource);
        });

        return dataSourceMap;
    }
}
