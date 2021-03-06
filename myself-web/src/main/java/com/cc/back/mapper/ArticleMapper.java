package com.cc.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.back.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 文章列表
     * @param map
     * @return
     */
    List<Article> findArticleList(Map<String ,Object> map);

    /**
     * 文章列表条目数
     * @param map
     * @return
     */
    Integer findArticleListConut(Map<String ,Object> map);

    /**
     * 根据id获取文章信息
     * @param id
     * @return
     */
    Article getArticleById(Integer id);
}