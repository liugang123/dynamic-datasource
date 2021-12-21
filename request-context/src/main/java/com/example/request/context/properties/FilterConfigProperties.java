package com.example.request.context.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置信息类
 *
 * @author liugang
 * @create 2021/12/16
 */
@ConfigurationProperties(prefix = FilterConfigProperties.PREFIX)
@Data
public class FilterConfigProperties {

    public static final String PREFIX = "com.example.filter";

    @Data
    public static class BasicRequestContextFilter {

        private boolean enable;
    }

}
