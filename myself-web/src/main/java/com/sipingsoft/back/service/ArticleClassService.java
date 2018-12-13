package com.sipingsoft.back.service;

import com.baomidou.mybatisplus.service.IService;
import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-12-13
 */
public interface ArticleClassService extends IService<ArticleClass> {


    /**
     * 新增文章分类
     * @param articleClass
     * @return
     */
    ResponseMessage<ArticleClass> insertArticleClass(ArticleClass articleClass);

    /**
     * 文章分类列表
     * @param articleClass
     * @return
     */
    PageResponse<ArticleClass> findArticleClassList(Integer page,Integer rows,ArticleClass articleClass);
}
