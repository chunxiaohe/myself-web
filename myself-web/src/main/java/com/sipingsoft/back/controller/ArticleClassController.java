package com.sipingsoft.back.controller;


import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.back.service.ArticleClassService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文章分类 前端控制器
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-12-13
 */
@RestController
public class ArticleClassController {

    @Autowired
    private ArticleClassService articleClassService;


    /**
     * 文章分类列表
     * @param page
     * @param rows
     * @param articleClass
     * @return
     */
    @GetMapping("back/api/list/articleClass")
    public PageResponse<ArticleClass> findArticleClassList(Integer page,Integer rows,ArticleClass articleClass){
        return  articleClassService.findArticleClassList(page,rows,articleClass);
    }

    /**
     * 插入文章分类
     * @param articleClass
     * @return
     */
    @GetMapping("/back/api/insert/articleClass")
    public ResponseMessage<ArticleClass> insetArticleClass( ArticleClass articleClass){
        return articleClassService.insertArticleClass(articleClass);
    }

    /**
     * 更新文章分类启用类型
     * @param articleClass
     * @return
     */
    @GetMapping("/back/api/update/isUse")
    public ResponseMessage<ArticleClass> updateIsUseById(ArticleClass articleClass){
        return articleClassService.updateIsUseById(articleClass);
    }

    /**
     * 删除文章分类
     * @param id
     * @return
     */
    @GetMapping("/back/api/delete/articleClass")
    public ResponseMessage<ArticleClass> deleteArticleClassById(Integer id){
        return articleClassService.deleteArticleClassById(id);
    }

}

