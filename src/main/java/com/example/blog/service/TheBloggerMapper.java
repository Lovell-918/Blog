package com.example.blog.service;

import com.example.blog.entity.TheBlogger;

public interface TheBloggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TheBlogger record);

    int insertSelective(TheBlogger record);

    TheBlogger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TheBlogger record);

    int updateByPrimaryKey(TheBlogger record);
}