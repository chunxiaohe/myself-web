package com.cc.back.controller;

import com.cc.back.entity.Slideshow;
import com.cc.back.service.SlideshowService;
import com.cc.core.entity.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeChunXiao
 * @since 2019-01-07 9:51
 */
@RestController
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    /**
     * 轮播图片列表
     * @return
     */
    @GetMapping("/back/api/slideshow/list")
    public PageResponse<Slideshow> findSlideshowList(Integer page,Integer rows){
        return slideshowService.findSlideshowList(page,rows);
    }
}
