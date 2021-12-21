package com.example.route.datasource.provider;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 动态数据源构造方
 *
 * @author liugang
 * @create 2021/12/20
 */
public interface DynamicDataSourceProvier {

    /**
     * 加载数据源
     *
     * @return
     */
    Map<String, DataSource> loadDataSources();
}
