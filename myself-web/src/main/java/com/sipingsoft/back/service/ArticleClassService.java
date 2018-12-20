package com.sipingsoft.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
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

    /**
     * 更新文章分类状态(1:启用 2:禁用)
     * @param articleClass
     * @return
     */
    ResponseMessage<ArticleClass> updateArticleClassById(ArticleClass articleClass);

    /**
     * 删除 文章分类
     * @param id 分类id
     * @return
     */
    ResponseMessage<ArticleClass> deleteArticleClassById(Integer id);

    /**
     * 更新文章分类名
     * @param articleClass
     * @return
     */
    ResponseMessage<ArticleClass> updateTypeNameById(ArticleClass articleClass);
}
