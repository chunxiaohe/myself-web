package com.sipingsoft.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sipingsoft.back.entity.PayType;
import com.sipingsoft.back.mapper.PayTypeMapper;
import com.sipingsoft.back.service.PayTypeService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HeChunXiao
 * @since 2018-12-18 上午 11:56
 */
@Service
public class PayTypeServiceImpl implements PayTypeService {

    @Autowired
    private PayTypeMapper payTypeMapper;

    /**
     * 支付方式列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResponse<PayType> findPayTypeList(Integer page,Integer rows) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.last("LIMIT "+(page-1)*rows+","+rows);
        List<PayType> list = payTypeMapper.selectList(queryWrapper);
        Integer totalCount = payTypeMapper.selectCount(queryWrapper);
        return PageResponse.getPageResponse(list,totalCount,page,rows);
    }

    @Override
    public ResponseMessage<PayType> deletePayTypeById(Integer id) {
        payTypeMapper.deleteById(id);
        return new ResponseMessage<>(200,"删除成功");
    }
}
