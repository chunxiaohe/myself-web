package com.sipingsoft.back.service;

import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.core.entity.ResponseMessage;

/**
 * @author HeChunXiao
 * @since 2018-12-13 上午 9:28
 */
public interface ArticleClassService {

    /**
     * 插入文章分类
     * @param articleClass
     * @return
     */
    ResponseMessage<ArticleClass> insert(ArticleClass articleClass);
}
