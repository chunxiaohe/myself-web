package com.sipingsoft.back.service;

import com.sipingsoft.back.entity.PayType;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;

/**
 * @author HeChunXiao
 * @since 2018-12-18 上午 11:52
 */
public interface PayTypeService {

    /**
     * 支付方式列表\
     * @param page
     * @param rows
     * @return
     */
    PageResponse<PayType> findPayTypeList(Integer page,Integer rows);

    /**
     * 删除支付方式
     * @param id
     * @return
     */
    ResponseMessage<PayType> deletePayTypeById(Integer id);

}
