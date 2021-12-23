package com.example.route.datasource.annotation;

import java.lang.annotation.*;

/**
 * 数据源注解
 *
 * @author liugang
 * @create 2021/12/23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface DataSource {

    /**
     * 数据源名称
     *
     * @return
     */
    String name();
}
