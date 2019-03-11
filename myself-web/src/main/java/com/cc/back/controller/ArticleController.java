package com.cc.back.controller;

import com.cc.back.entity.Article;
import com.cc.back.service.ArticleService;
import com.cc.core.entity.PageResponse;
import com.cc.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
     *
     * @param article 查询参数实体
     * @param page    页数
     * @param rows    条目数
     * @return
     */
    @GetMapping("/back/api/article/list")
    public PageResponse<Article> findArticleList(Article article, Integer page, Integer rows, String sord) {
        return articleService.findArticleList(article, page, rows, sord);
    }

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    @PostMapping("/back/api/article/update")
    public ResponseMessage<Article> updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    /**
     * 新增文章
     *
     * @param article
     * @return
     */
    @PostMapping("/back/api/article/insert")
    public ResponseMessage<Integer> insertArticle(@RequestParam(value = "file",required = false) MultipartFile file, Article article) {
        return articleService.insertArticle(file, article);
    }

}
