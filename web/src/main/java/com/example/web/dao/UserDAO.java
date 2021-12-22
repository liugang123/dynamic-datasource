package com.example.web.dao;

import com.example.web.dao.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author liugang
 * @create 2021/12/21
 */
@Mapper
public interface UserDAO {

    @Select(value = "select * from user where id=#{value}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    UserPO getUserById(String id);
}
