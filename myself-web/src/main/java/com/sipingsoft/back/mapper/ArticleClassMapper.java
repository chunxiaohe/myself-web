package com.sipingsoft.back.mapper;

import com.sipingsoft.back.entity.ArticleClass;

/**
* Created by Mybatis Generator 2018/12/12
*/
public interface ArticleClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleClass record);

    int insertSelective(ArticleClass record);

    ArticleClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleClass record);

    int updateByPrimaryKey(ArticleClass record);
}