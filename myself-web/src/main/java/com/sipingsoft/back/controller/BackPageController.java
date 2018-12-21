package com.sipingsoft.back.controller;

import com.sipingsoft.back.entity.SysUser;
import com.sipingsoft.core.shiro.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 后台页面控制类
 *
 * @author He Chunxiao
 * @since 2018-11-15 10:38:45
 */
@Controller
public class BackPageController {

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
     * @return
     */
    @GetMapping("/back/page/articleClass")
    public  String atricleClass(){
        return BackPageUtil.BACK_ARTICLE_CLASS;
    }

    /**
     *  新增文章分类的弹出页面
     * @return
     */
    @GetMapping("/back/page/addArticleClass")
    public String addAtricleClass(){
        return BackPageUtil.BACK_ADD_ARTICLE_CLASS;
    }

    /**
     * 支付方式列表页面
     * @return
     */
    @GetMapping("/back/page/payType")
    public String payType(){
        return BackPageUtil.BACK_PAY_TYPE;
    }

    /**
     * 新增支付方式的弹出页面
     * @return
     */
    @GetMapping("/back/page/addPaytype")
    public String addPayType(){
        return BackPageUtil.BACK_ADD_PAY_TYPE;
    }

    /**
     * 文章列表
     * @return
     */
    @GetMapping("/back/page/article")
    public String article(){
        return BackPageUtil.BACK_ARTICLE;
    }
}