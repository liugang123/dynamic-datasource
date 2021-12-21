package com.example.web.dao.po;

import lombok.Data;

import java.util.Date;

/**
 * @author liugang
 * @create 2021/12/21
 */
@Data
public class UserPO {

    private String id;

    private Integer status;

    private Date createTime;
}
