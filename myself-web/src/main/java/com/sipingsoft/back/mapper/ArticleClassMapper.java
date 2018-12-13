package com.sipingsoft.back.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sipingsoft.back.entity.ArticleClass;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 Mapper 接口
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-12-13
 */
public interface ArticleClassMapper extends BaseMapper<ArticleClass> {

    /**
     * 文章分类列表
     * @param map
     * @return
     */
    List<ArticleClass> findArticleClassList(Map<String,Object> map);

    /**
     *总条目数
     */
    Integer findArticleClassCount(Map<String,Object> map);
}
