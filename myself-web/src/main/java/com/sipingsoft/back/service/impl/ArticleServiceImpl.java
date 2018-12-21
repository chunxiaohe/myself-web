package com.sipingsoft.back.service.impl;

import com.sipingsoft.back.entity.Article;
import com.sipingsoft.back.mapper.ArticleMapper;
import com.sipingsoft.back.service.ArticleService;
import com.sipingsoft.core.entity.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeChunXiao
 * @since 2018-12-21 16:07
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 文章列表
     * @param article
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResponse<Article> findArticleList(Article article, Integer page, Integer rows) {
        Map<String,Object> map = new HashMap<>();
        map.put("article",article);
        map.put("pageStart",(page-1)*rows);
        map.put("pageSize",rows);
        List<Article> list = articleMapper.findArticleList(map);
        Integer totalCount = articleMapper.findArticleListConut(map);
        return PageResponse.getPageResponse(list,totalCount,page,rows);
    }
}
