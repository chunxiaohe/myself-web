package com.cc.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.back.entity.Slideshow;

import java.util.List;
import java.util.Map;

public interface SlideshowMapper extends BaseMapper<Slideshow> {

    List<Slideshow> findSlideshowList(Map<String,Object> map);
}