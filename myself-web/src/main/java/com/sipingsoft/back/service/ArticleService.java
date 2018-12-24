package com.sipingsoft.back.service;

import com.sipingsoft.back.entity.Article;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;

/**
 * @author HeChunXiao
 * @since 2018-12-21 16:06
 */
public interface ArticleService {

    /**
     * 文章列表
     * @param article
     * @param page
     * @param rows
     * @return
     */
    PageResponse<Article> findArticleList(Article article, Integer page, Integer rows);

    /**
     * 更新文章
     * @param article
     * @return
     */
    ResponseMessage<Article> updateArticle(Article article);
}
