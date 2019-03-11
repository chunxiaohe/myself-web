package com.cc.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.back.entity.Article;
import com.cc.back.entity.ArticleClass;
import com.cc.back.entity.SysUser;
import com.cc.back.mapper.ArticleClassMapper;
import com.cc.back.mapper.ArticleMapper;
import com.cc.back.service.ArticleClassService;
import com.cc.core.entity.PageResponse;
import com.cc.core.entity.ResponseMessage;
import com.cc.core.shiro.ShiroUtils;
import com.cc.core.util.SimpleDateFormatUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-12-13
 */
@Service
public class ArticleClassServiceImpl extends ServiceImpl<ArticleClassMapper, ArticleClass> implements ArticleClassService {

    @Autowired
    private ArticleClassMapper articleClassMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 插入文章分类
     *
     * @param articleClass
     * @return
     */
    @Override
    public ResponseMessage<ArticleClass> insertArticleClass(ArticleClass articleClass) {
        //查找是否有同名文章分类
        QueryWrapper<ArticleClass> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ArticleClass::getTypeName, articleClass.getTypeName());
        Integer count = articleClassMapper.selectCount(queryWrapper);
        if (count > 0) {
            return new ResponseMessage<>(500, "文章分类名已存在");
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createDate = simpleDateFormat.format(date);
        articleClass.setCreateDate(createDate);
        SysUser sysUser = ShiroUtils.getLoginUser();
        articleClass.setCreateBy(sysUser.getUserId().intValue());
        articleClassMapper.insert(articleClass);
        return new ResponseMessage<>(200, "插入成功");
    }

    /**
     * 文章分类列表
     *
     * @param page
     * @param rows
     * @param articleClass
     * @return
     */
    @Override
    public PageResponse<ArticleClass> findArticleClassList(Integer page, Integer rows, ArticleClass articleClass) {
        Map<String, Object> map = new HashMap<>();
        map.put("articleClass", articleClass);
        map.put("pageStart", (page - 1) * rows);
        map.put("pageSize", rows);
        List<ArticleClass> list = articleClassMapper.findArticleClassList(map);
        Integer totalCount = articleClassMapper.findArticleClassCount(map);
        return PageResponse.getPageResponse(list, totalCount, page, rows);
    }

    /**
     * 更新文章分类状态
     *
     * @param articleClass
     * @return
     */
    @Override
    public ResponseMessage<ArticleClass> updateArticleClassById(ArticleClass articleClass) {
        if (articleClass.getTypeName() != null && articleClass.getTypeName().trim() != "") {
            //查找是否有同名文章分类
            QueryWrapper<ArticleClass> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("type_name",articleClass.getTypeName());
            queryWrapper.ne("id",articleClass.getId());
            List<ArticleClass> list = articleClassMapper.selectList(queryWrapper);
            if(CollectionUtils.isNotEmpty(list)){
                return new ResponseMessage<>(500,"文章分类名已存在");
            }
        }
        if (articleClass.getTypeName() != null && articleClass.getTypeName().trim() == "") {
            return new ResponseMessage<>(500, "请填写文章分类名称");
        }
        Date date = new Date();
        articleClass.setUpdateDate(SimpleDateFormatUtil.dateToString(date, "yyyy-MM-dd hh:mm:ss"));
        SysUser sysUser = ShiroUtils.getLoginUser();
        articleClass.setUpdateBy(sysUser.getUserId().intValue());
        articleClassMapper.updateById(articleClass);
        return new ResponseMessage<>(200,"文章分类更新成功");
    }

    /**
     * 删除文章分类
     *
     * @param id 分类id
     * @return
     */
    @Override
    public ResponseMessage<ArticleClass> deleteArticleClassById(Integer id) {
        //判断删除的文章分类下是否含有相关文章
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Map<String,Object> map = new HashMap<>();
        map.put("article_class_id",id);
        map.put("is_delete",1);
        queryWrapper.allEq(map);
        List<Article> list = articleMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(list)){
            return new ResponseMessage<>(500,"该分类下包含文章,请删除或移动文章后重试");
        }
        articleClassMapper.deleteById(id);
        return new ResponseMessage<>(200, "删除成功");
    }

    /**
     * 获取所有启用/禁用的文章分类
     *
     * @param isUse 1.启用 2.禁用
     * @return
     */
    @Override
    public ResponseMessage<ArticleClass> getAllArticleClass(Integer isUse) {
        QueryWrapper<ArticleClass> queryWrapper = new QueryWrapper<>();
        if (isUse != null ) {
            queryWrapper.eq("is_use", isUse);
        }
        List<ArticleClass> list = articleClassMapper.selectList(queryWrapper);
        return new ResponseMessage<>(200, list);
    }
}
