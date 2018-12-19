package com.sipingsoft.back.service;

import com.sipingsoft.back.entity.PayType;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * @author HeChunXiao
 * @since 2018-12-18 上午 11:52
 */
public interface PayTypeService {

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
