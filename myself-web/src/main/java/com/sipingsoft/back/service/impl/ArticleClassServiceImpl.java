package com.sipingsoft.back.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.back.entity.SysUser;
import com.sipingsoft.back.mapper.ArticleClassMapper;
import com.sipingsoft.back.service.ArticleClassService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.shiro.ShiroUtils;
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

    @Override
    public ResponseMessage<ArticleClass> insertArticleClass(ArticleClass articleClass) {
        //查找是否有同名文章分类
        EntityWrapper<ArticleClass> ew = new EntityWrapper<>();
        ew.where("type_name={0}",articleClass.getTypeName());
        Integer count =  articleClassMapper.selectCount(ew);
        if (count>0){
            return new ResponseMessage<>(500,"文章分类名已存在");
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createDate =  simpleDateFormat.format(date);
        articleClass.setCreateDate(createDate);
        SysUser sysUser = ShiroUtils.getLoginUser();
        articleClass.setCreateBy(sysUser.getUserId().intValue());
        articleClassMapper.insert(articleClass);
        return new ResponseMessage<>(200,"插入成功");
    }

    @Override
    public PageResponse<ArticleClass> findArticleClassList(Integer page , Integer rows ,ArticleClass articleClass) {
        Map<String,Object> map = new HashMap<>();
        map.put("articleClass",articleClass);
        map.put("pageStart",(page-1)*rows);
        map.put("pageSize",rows);
        List<ArticleClass> list =  articleClassMapper.findArticleClassList(map);
        Integer count = articleClassMapper.findArticleClassCount(map);
        return PageResponse.getPageResponse(list,count,page,rows);
    }
}
