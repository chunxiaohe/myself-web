package com.sipingsoft.back.service.impl;

import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.back.mapper.ArticleClassMapper;
import com.sipingsoft.back.service.ArticleClassService;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HeChunXiao
 * @since 2018-12-13 上午 9:46
 */
@Service
public class ArticleClassServiceImpl implements ArticleClassService {

    @Autowired
    private ArticleClassMapper articleClassMapper;

    @Override
    public ResponseMessage<ArticleClass> insert(ArticleClass articleClass) {
        articleClassMapper.insert(articleClass);
        return new ResponseMessage<>(200,"新增成功");
    }
}
