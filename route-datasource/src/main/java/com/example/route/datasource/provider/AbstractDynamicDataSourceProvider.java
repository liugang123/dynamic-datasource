package com.example.route.datasource.provider;

import com.example.route.datasource.provider.creator.DataSourceCreator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 数据源提供者抽象类
 *
 * @author liugang
 * @create 2021/12/20
 */
public abstract class AbstractDynamicDataSourceProvider implements DynamicDataSourceProvier {

    @Autowired
    private List<DataSourceCreator> dataSourceCreatorList;

    /**
     * 获取不同数据库的dataSource创建类
     *
     * @param key
     * @return
     */
    public DataSourceCreator getDataSourceCreator(String key) {
        //return dataSourceCreatorList.stream().filter(f -> Objects.equals(f.dataSourceType().getName(), key)).findFirst().orElse(null);
        return dataSourceCreatorList.get(0);
    }
}
