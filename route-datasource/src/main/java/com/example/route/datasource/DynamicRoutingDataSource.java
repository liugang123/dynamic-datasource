package com.example.route.datasource;

import com.example.route.datasource.toolkit.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 数据源动态切换类
 *
 * @author liugang
 * @create 2021/12/17
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private Map<String, DataSource> targetDynamicDataSources;

    public DynamicRoutingDataSource(Map<String, DataSource> targetDynamicDataSource) {
        this.targetDynamicDataSources = targetDynamicDataSource;
    }

    /**
     * 重写父类数据源
     *
     * @param targetDataSources
     */
    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        // todo::

        super.setTargetDataSources(targetDataSources);
    }

    /**
     * 指定动态数据源的key
     *
     * @return
     */
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }
}
