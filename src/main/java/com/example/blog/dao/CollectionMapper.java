package com.example.blog.dao;

import com.example.blog.entity.CollectionKey;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionMapper {
    int deleteByPrimaryKey(CollectionKey key);

    int insert(CollectionKey record);

    int insertSelective(CollectionKey record);
}