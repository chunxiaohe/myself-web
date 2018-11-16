package com.sipingsoft.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author HeChunXiao
 * @since 2018-11-14 下午 3:38
 */
@Controller
public class BolgPageController {

    @GetMapping("/blog/page/index")
    public String blogIndex(){
        return BlogPageUtil.BLOG_INDEX;
    }
}
