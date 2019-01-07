package com.sipingsoft.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sipingsoft.back.entity.Slideshow;
import com.sipingsoft.back.mapper.SlideshowMapper;
import com.sipingsoft.back.service.SlideshowService;
import com.sipingsoft.core.entity.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeChunXiao
 * @since 2019-01-07 10:02
 */
@Service
public class SlideshowServiceImpl extends ServiceImpl<SlideshowMapper,Slideshow> implements SlideshowService {

    @Autowired
    private SlideshowMapper slideshowMapper;

    @Override
    public PageResponse<Slideshow> findSlideshowList(Integer page,Integer rows) {
        Map<String ,Object> map = new HashMap<>();
        map.put("pageStart",(page-1)*rows);
        map.put("pageSize",rows);
        List<Slideshow >list = slideshowMapper.findSlideshowList(map);
        Integer totalCount = slideshowMapper.selectCount(new QueryWrapper<>());
        return PageResponse.getPageResponse(list,totalCount,page,rows);
    }
}
