package com.fsd2020.security.data.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fsd2020.security.data.User;

//@Mapper : 表示本类是一个 MyBatis 的 Mapper，等价于以前 Spring 整合 MyBatis 时的 Mapper 接口
@Mapper
@Repository
public interface UserMapper {

    //选择全部用户
    List<User> selectUser();
    //根据id选择用户
    User selectUserById(int id);
}
