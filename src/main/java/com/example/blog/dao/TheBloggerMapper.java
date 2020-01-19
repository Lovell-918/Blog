package com.example.blog.dao;

import com.example.blog.entity.TheBlogger;
import org.springframework.stereotype.Repository;

@Repository
public interface TheBloggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TheBlogger record);

    int insertSelective(TheBlogger record);

    TheBlogger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TheBlogger record);

    int updateByPrimaryKey(TheBlogger record);
}