package com.example.blog.dao;

import com.example.blog.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    //这是我加的
    User selectUserByUserName(String name);
}