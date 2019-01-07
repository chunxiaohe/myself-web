package com.sipingsoft.back.controller;

import com.sipingsoft.back.entity.Article;
import com.sipingsoft.back.entity.ArticleClass;
import com.sipingsoft.back.entity.Slideshow;
import com.sipingsoft.back.entity.SysUser;
import com.sipingsoft.back.service.ArticleClassService;
import com.sipingsoft.back.service.ArticleService;
import com.sipingsoft.back.service.SlideshowService;
import com.sipingsoft.core.shiro.ShiroUtils;
import com.sipingsoft.core.util.FormatDateUtil;
import com.sipingsoft.core.util.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

/**
 * 后台页面控制类
 *
 * @author He Chunxiao
 * @since 2018-11-15 10:38:45
 */
@Controller
public class BackPageController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleClassService articleClassService;

    @Autowired
    private SlideshowService slideshowService;

    /**
     * 后台 登录页
     *
     * @return
     */
    @GetMapping("/back/page/login")
    public String login() {
        SysUser sysUser = ShiroUtils.getLoginUser();
        if (sysUser != null) {
            //已登录 进入后台主页
            return "redirect:/back/page/index";
        } else {
            //未登录 进入登录后台页面
            return BackPageUtil.BACK_LOGIN;
        }
    }


    /**
     * 后台 主页
     *
     * @param map
     * @return
     */
    @GetMapping("/back/page/index")
    public String index(ModelMap map) {
        SysUser user = ShiroUtils.getLoginUser();
        map.put("username", user.getUsername());
        return BackPageUtil.BACK_INDEX;
    }

    /**
     * 后台 主页 首页
     *
     * @return
     */
    @GetMapping("/back/page/index/content")
    public String indexContent() {
        return BackPageUtil.BACK_INDEX_CONTENT;
    }

    /**
     * 文章分类页面
     *
     * @return
     */
    @GetMapping("/back/page/articleClass")
    public String atricleClass() {
        return BackPageUtil.BACK_ARTICLE_CLASS;
    }

    /**
     * 新增文章分类的弹出页面
     *
     * @return
     */
    @GetMapping("/back/page/addArticleClass")
    public String updateAtricleClass(ModelMap map, Integer id) {
        //编辑
        if (id != null && id.toString().trim() != "") {
            ArticleClass articleClass =  articleClassService.getById(id);
            map.put("articleClass",articleClass);
        }
        return BackPageUtil.BACK_ADD_ARTICLE_CLASS;
    }

    /**
     * 支付方式列表页面
     *
     * @return
     */
    @GetMapping("/back/page/payType")
    public String payType() {
        return BackPageUtil.BACK_PAY_TYPE;
    }

    /**
     * 新增支付方式的弹出页面
     *
     * @return
     */
    @GetMapping("/back/page/addPaytype")
    public String addPayType() {
        return BackPageUtil.BACK_ADD_PAY_TYPE;
    }

    /**
     * 文章列表
     *
     * @return
     */
    @GetMapping("/back/page/article")
    public String article() {
        return BackPageUtil.BACK_ARTICLE;
    }

    /**
     * 添加/修改文章 页面
     *
     * @param map 返回的数据map
     * @param id  文章id
     * @return
     */
    @GetMapping("/back/page/edit/article")
    public String articleEdit(ModelMap map, Integer id) {
        List<ArticleClass> list = null;
        if (id != null && id.toString().trim() != "") {
            //修改页面
            map.put("type", 1);
            Article article = articleService.getArticleById(id);
            String date = article.getCreateDate().substring(0, article.getCreateDate().lastIndexOf("."));
            article.setCreateDate(date);
            map.put("article", article);
            //获取所有的文章分类(启用和禁用)
            list = articleClassService.getAllArticleClass(null).getData();
        } else {
            //新增页面
            map.put("type", 2);
            SysUser sysUser = ShiroUtils.getLoginUser();
            Article article = new Article();
            article.setCreateDate(SimpleDateFormatUtil.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss"));
            article.setCreateName(sysUser.getName());
            article.setCreateBy(sysUser.getUserId().intValue());
            map.put("article", article);
            //获取可用文章分类(启用)
            list = articleClassService.getAllArticleClass(1).getData();
        }
        map.put("articleClass", list);

        return BackPageUtil.BACK_ARTICLE_EDIT;
    }

    /**
     * 图片轮播管理
     * @return
     */
    @GetMapping("/back/page/slideShow")
    public String slideShow(){
        return BackPageUtil.BACK_SLIDESHOW;
    }

    /**
     * 新增/修改 图片轮播页面
     * @return
     */
    public String addSlideshow(ModelMap map, Integer id){
        Slideshow slideshow = slideshowService.getById(id);
        map.put("slideshow",slideshow);
        return BackPageUtil.BACK_ADD_SLIDESHOW;
    }
}