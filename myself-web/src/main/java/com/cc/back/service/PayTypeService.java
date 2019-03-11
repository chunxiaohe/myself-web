package com.cc.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.back.entity.PayType;
import com.cc.core.entity.PageResponse;
import com.cc.core.entity.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HeChunXiao
 * @since 2018-12-18 上午 11:52
 */
public interface PayTypeService extends IService<PayType> {

    /**
     * 支付方式列表\
     *
     * @param page
     * @param rows
     * @return
     */
    PageResponse<PayType> findPayTypeList(Integer page, Integer rows);

    /**
     * 删除支付方式
     *
     * @param id
     * @return
     */
    ResponseMessage<PayType> deletePayTypeById(Integer id, String address);

    /**
     * 上传支付方式
     *
     * @param file   图片文件
     * @param type   支付类型
     * @param remark 备注
     * @return
     */
    ResponseMessage<PayType> uploadPayType(MultipartFile file, Integer type, String remark);

    /**
     * 更新支付方式
     *
     * @param payType
     * @return
     */
    ResponseMessage<PayType> updatePayType(PayType payType);
}
