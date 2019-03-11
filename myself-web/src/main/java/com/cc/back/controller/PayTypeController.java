package com.cc.back.controller;

import com.cc.back.entity.PayType;
import com.cc.back.service.PayTypeService;
import com.cc.core.entity.PageResponse;
import com.cc.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     *
     * @param page 页数
     * @param rows 每页显示的条目数
     * @return
     */
    @GetMapping("/back/api/payType/list")
    public PageResponse<PayType> findPayTypeList(Integer page, Integer rows) {
        return payTypeService.findPayTypeList(page, rows);
    }

    /**
     * 删除支付方式
     *
     * @param id
     * @return
     */
    @GetMapping("/back/api/delete/payType")
    public ResponseMessage<PayType> deletePayTypeById(Integer id, String address) {
        return payTypeService.deletePayTypeById(id, address);
    }

    /**
     * 上传支付方式
     *
     * @param file 支付方式的二维码图片
     * @param type 二维码类型 1.微信 2.支付宝
     * @return
     */
    @RequestMapping(value = "/back/api/upload/payType", method = RequestMethod.POST)
    public ResponseMessage<PayType> uploadPayType(@RequestParam("file") MultipartFile file, Integer type, String remark) {
        return payTypeService.uploadPayType(file, type, remark);
    }

    /**
     * 更新支付方式.
     *
     * @param payType
     * @return
     */
    @PostMapping("/back/api/update/payType")
    public ResponseMessage<PayType> updatePayType(PayType payType) {
        return payTypeService.updatePayType(payType);
    }
}
