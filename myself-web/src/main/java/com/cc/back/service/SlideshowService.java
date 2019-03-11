package com.cc.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.back.entity.Slideshow;
import com.cc.core.entity.PageResponse;

/**
 * @author HeChunXiao
 * @since 2019-01-07 9:59
 */
public interface SlideshowService extends IService<Slideshow> {

    PageResponse<Slideshow> findSlideshowList(Integer page,Integer rows);
}
