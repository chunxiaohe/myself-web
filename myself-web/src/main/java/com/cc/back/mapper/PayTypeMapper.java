package com.cc.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.back.entity.PayType;

import java.util.List;
import java.util.Map;

public interface PayTypeMapper extends BaseMapper<PayType> {

    /**
     * 支付方式列表
     * @param map
     * @return
     */
    List<PayType> findPayTypeList(Map<String ,Object> map);

    /**
     * 支付方式条目数
     * @return
     */
    Integer getTotalCount();
}