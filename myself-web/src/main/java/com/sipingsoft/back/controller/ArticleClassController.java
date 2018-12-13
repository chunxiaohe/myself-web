package com.sipingsoft.back.controller;

import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.back.service.ArticleClassService;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章分类控制层
 * @author HeChunXiao
 * @since 2018-12-13 上午 9:58
 */
@RestController
public class ArticleClassController {

    @Autowired
    private ArticleClassService articleClassService;

    /**
     * 插入文章分类
     * @param articleClass 文章分类实体
     * @return
     */
    @GetMapping("/back")
    public ResponseMessage<ArticleClass> insert(ArticleClass articleClass){
        return articleClassService.insert(articleClass);
    }
}
