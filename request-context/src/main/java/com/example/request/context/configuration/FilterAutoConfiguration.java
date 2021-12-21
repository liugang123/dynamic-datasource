package com.example.request.context.configuration;

import com.example.request.context.filter.BasicRequestContextFilter;
import com.example.request.context.properties.FilterConfigProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置类
 *
 * @author liugang
 * @create 2021/12/16
 */
@Configuration
@EnableConfigurationProperties(FilterConfigProperties.class)
public class FilterAutoConfiguration {

    @Bean
    @ConditionalOnProperty(name = "com.example.filter.basicRequestContextFilter.enable", havingValue = "true")
    public BasicRequestContextFilter basicRequestContextFilter() {
        return new BasicRequestContextFilter();
    }

}
