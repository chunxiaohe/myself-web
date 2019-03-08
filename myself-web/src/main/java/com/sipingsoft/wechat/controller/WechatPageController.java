package com.sipingsoft.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author He Chunxiao
 * @date 2019-03-08 10:09
 * @desc
 */
@Controller
@RequestMapping("/wechat")
public class WechatPageController {

    /**
     *
     * @return
     */
    @GetMapping("/page/getAnime")
    public String getWechatAnimePage(){
       return WechatPageUtil.WECHAT_PAGE_ANIME;
    }
}
