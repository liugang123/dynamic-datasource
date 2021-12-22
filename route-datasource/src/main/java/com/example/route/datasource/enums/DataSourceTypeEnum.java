package com.example.route.datasource.enums;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

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

    public static DataSourceTypeEnum getEnumByName(String name) {
        if (StrUtil.isBlank(name)) {
            return null;
        }
        for (DataSourceTypeEnum item : DataSourceTypeEnum.values()) {
            if (Objects.equals(item.getName(), name)) {
                return item;
            }
        }
        return null;
    }

}
