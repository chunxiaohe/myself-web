package com.cc.back.controller;


import com.cc.back.entity.ArticleClass;
import com.cc.back.service.ArticleClassService;
import com.cc.core.entity.PageResponse;
import com.cc.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("back/api/articleClass/list")
    public PageResponse<ArticleClass> findArticleClassList(Integer page,Integer rows,ArticleClass articleClass){
        return  articleClassService.findArticleClassList(page,rows,articleClass);
    }

    /**
     * 插入文章分类
     * @param articleClass
     * @return
     */
    @GetMapping("/back/api/articleClass/insert")
    public ResponseMessage<ArticleClass> insetArticleClass( ArticleClass articleClass){
        return articleClassService.insertArticleClass(articleClass);
    }

    /**
     * 更新文章分类信息
     * @param articleClass
     * @return
     */
    @RequestMapping("/back/api/articleClass/update")
    public ResponseMessage<ArticleClass> updateIsUseById(ArticleClass articleClass){
        return articleClassService.updateArticleClassById(articleClass);
    }

    /**
     * 删除文章分类
     * @param id
     * @return
     */
    @GetMapping("/back/api/articleClass/delete")
    public ResponseMessage<ArticleClass> deleteArticleClassById(Integer id){
        return articleClassService.deleteArticleClassById(id);
    }

    /**
     * 获取启用/禁用的所有文章分类
     * @param isUse 1.启用 2.禁用
     * @return
     */
    @GetMapping("/back/api/articleClass/getAll")
    public ResponseMessage<ArticleClass> getAllArticleClass(Integer isUse){
        return articleClassService.getAllArticleClass(isUse);
    }
}

