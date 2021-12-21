package com.example.route.datasource.toolkit;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.example.route.datasource.enums.DataSourceTypeEnum;

/**
 * 动态数据切换应用上下文
 *
 * @author liugang
 * @create 2021/12/17
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceTypeEnum> threadLocal = new TransmittableThreadLocal<DataSourceTypeEnum>();

    public static DataSourceTypeEnum getDataSource() {
        return threadLocal.get();
    }

    public static void setDataSource(DataSourceTypeEnum dataSourceType) {
        threadLocal.set(dataSourceType);
    }

    public static void clear() {
        threadLocal.remove();
    }
}
