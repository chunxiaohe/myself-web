package com.sipingsoft.back.service;

import com.sipingsoft.back.entity.Article;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HeChunXiao
 * @since 2018-12-21 16:06
 */
public interface ArticleService {

    /**
     * 文章列表
     *
     * @param article
     * @param page
     * @param rows
     * @return
     */
    PageResponse<Article> findArticleList(Article article, Integer page, Integer rows, String sord);

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    ResponseMessage<Article> updateArticle(Article article);

    /**
     * 根据文章id 查找文章信息
     *
     * @param id
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 新增文章
     *
     * @param article
     * @return
     */
    ResponseMessage<Integer> insertArticle(MultipartFile file, Article article);

}
