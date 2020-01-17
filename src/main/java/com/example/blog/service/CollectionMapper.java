package com.example.blog.service;

import com.example.blog.entity.CollectionKey;

public interface CollectionMapper {
    int deleteByPrimaryKey(CollectionKey key);

    int insert(CollectionKey record);

    int insertSelective(CollectionKey record);
}