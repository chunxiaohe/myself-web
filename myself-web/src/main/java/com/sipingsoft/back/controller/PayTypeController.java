package com.sipingsoft.back.controller;

import com.sipingsoft.back.entity.PayType;
import com.sipingsoft.back.service.PayTypeService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeChunXiao
 * @since 2018-12-18 下午 2:10
 */
@RestController
public class PayTypeController {

    @Autowired
    private PayTypeService payTypeService;

    /**
     * 支付方式列表
     * @param page 页数
     * @param rows 每页显示的条目数
     * @return
     */
    @GetMapping("/back/api/payType/list")
    public PageResponse<PayType> findPayTypeList(Integer page,Integer rows){
        return payTypeService.findPayTypeList(page, rows);
    }

    @GetMapping("/back/api/delete/payType")
    public ResponseMessage<PayType> deletePayTypeById(Integer id){
        return payTypeService.deletePayTypeById(id);
    }
}
