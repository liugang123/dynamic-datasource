package com.example.route.datasource.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liugang
 * @create 2021/12/17
 */
@Getter
@AllArgsConstructor
public enum DataSourceTypeEnum {

    MASTER("master", "主库"),
    SLAVE("slave", "从库");

    private final String name;
    private final String desc;
}
