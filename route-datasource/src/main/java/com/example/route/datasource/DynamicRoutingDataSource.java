package com.example.route.datasource;

import cn.hutool.json.JSONUtil;
import com.example.route.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源动态切换类
 *
 * @author liugang
 * @create 2021/12/17
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    public DynamicRoutingDataSource(Map<String, DataSource> targetDynamicDataSource) {
        // 转换成父类数据源对象
        Map<Object, Object> map = new HashMap<>();
        targetDynamicDataSource.forEach((key, value) -> {
            map.put(key, value);
        });
        // 设置父类数据源
        super.setTargetDataSources(map);
    }

    /**
     * 指定动态数据源的key
     *
     * @return
     */
    protected Object determineCurrentLookupKey() {
        Map<Object, DataSource> resolvedDataSources = super.getResolvedDataSources();
        log.info(">>>>>>动态设置数据源，resolvedDataSources:{}", JSONUtil.toJsonStr(resolvedDataSources.keySet()));

        String dataSourceKey = DynamicDataSourceContextHolder.getDataSource().getName();
        log.info(">>>>>>DynamicDataSourceContextHolder，清除localThread对像");
        return dataSourceKey;
    }
}
