package com.example.web.dao;

import com.example.web.dao.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author liugang
 * @create 2021/12/21
 */
@Mapper
public interface UserDAO {

    @Select(value = "select * from user where id=#{value}")
    UserPO getUserById(String id);
}
