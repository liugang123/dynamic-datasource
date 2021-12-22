package com.example.route.datasource.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 数据源配置类
 *
 * @author liugang
 * @create 2021/12/17
 */
@ConfigurationProperties(prefix = DynamicDataSourceProperties.PREFIX)
@Data
public class DynamicDataSourceProperties {

    public static final String PREFIX = "com.example.dynamic";

    private Boolean enable;

    private Map<String, DataSourceProperty> datasource;

    /**
     * 数据源信息
     */
    @Data
    public static class DataSourceProperty {

        private String url;

        private String username;

        private String password;

        private String driverClassName;
    }

}
