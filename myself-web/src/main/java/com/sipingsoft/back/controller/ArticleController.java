package com.sipingsoft.back.controller;

import com.sipingsoft.back.entity.Article;
import com.sipingsoft.back.service.ArticleService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeChunXiao
 * @since 2018-12-21 16:04
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表
     * @param article  查询参数实体
     * @param page 页数
     * @param rows 条目数
     * @return
     */
    @GetMapping("/back/api/article/list")
    public PageResponse<Article> findArticleList(Article article, Integer page, Integer rows,String sord){
        System.out.println(sord);
        return articleService.findArticleList(article, page, rows,sord);
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @PostMapping("/back/api/article/update")
    public ResponseMessage<Article> updateArticle(Article article){
        return articleService.updateArticle(article);
    }


}
