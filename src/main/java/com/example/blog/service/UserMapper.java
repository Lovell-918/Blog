package com.example.blog.service;

import com.example.blog.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}