package com.example.route.datasource.configuration;

import com.example.route.datasource.DynamicRoutingDataSource;
import com.example.route.datasource.aop.DynamicDataSourceAnnotationAdvisor;
import com.example.route.datasource.aop.DynamicDataSourceAnnotationInterceptor;
import com.example.route.datasource.properties.DynamicDataSourceProperties;
import com.example.route.datasource.provider.DynamicDataSourceProvier;
import com.example.route.datasource.provider.YmlDynamicDataSourceProvider;
import org.springframework.aop.Advisor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * 动态数据源动态配置类
 *
 * @author liugang
 * @create 2021/12/17
 */
@Configuration
@AutoConfigureBefore(value = DataSourceAutoConfiguration.class, name = "com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure")
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
@Import(DataSourceCreatorAutoConfiguration.class)
@ConditionalOnProperty(prefix = DynamicDataSourceProperties.PREFIX, name = "enable", havingValue = "true")
public class DynamicDataSourceAutoConfiguration {

    @Bean
    public DynamicDataSourceProvier dynamicDataSourceProvier(DynamicDataSourceProperties properties) {
        return new YmlDynamicDataSourceProvider(properties.getDatasource());
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource(DynamicDataSourceProvier dataSourceProvier) {
        return new DynamicRoutingDataSource(dataSourceProvier.loadDataSources());
    }

    @Bean
    @ConditionalOnProperty(prefix = DynamicDataSourceProperties.PREFIX + ".aop", name = "enable", havingValue = "true")
    public Advisor dynamicDataSourceAnnotationAdvisor() {
        DynamicDataSourceAnnotationInterceptor interceptor = new DynamicDataSourceAnnotationInterceptor();
        return new DynamicDataSourceAnnotationAdvisor(interceptor);
    }

}
