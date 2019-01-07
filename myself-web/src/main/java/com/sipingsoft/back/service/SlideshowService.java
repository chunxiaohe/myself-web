package com.sipingsoft.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sipingsoft.back.entity.Slideshow;
import com.sipingsoft.core.entity.PageResponse;

/**
 * @author HeChunXiao
 * @since 2019-01-07 9:59
 */
public interface SlideshowService extends IService<Slideshow> {

    PageResponse<Slideshow> findSlideshowList(Integer page,Integer rows);
}
