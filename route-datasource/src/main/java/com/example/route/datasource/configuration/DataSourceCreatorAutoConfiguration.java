package com.example.route.datasource.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.route.datasource.provider.creator.DruidDataSourceCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源配置类
 *
 * @author liugang
 * @create 2021/12/21
 */
@Configuration
public class DataSourceCreatorAutoConfiguration {

    @Configuration
    @ConditionalOnClass(DruidDataSource.class)
    static class DruidDataSourceCreatorConfiguration {

        @Bean
        public DruidDataSourceCreator druidDataSourceCreator() {
            return new DruidDataSourceCreator();
        }
    }

}
