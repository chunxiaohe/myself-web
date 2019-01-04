package com.sipingsoft.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sipingsoft.back.entity.PayType;
import com.sipingsoft.back.entity.SysUser;
import com.sipingsoft.back.mapper.PayTypeMapper;
import com.sipingsoft.back.service.PayTypeService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.shiro.ShiroUtils;
import com.sipingsoft.core.util.OperationImageUtil;
import com.sipingsoft.core.util.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HeChunXiao
 * @since 2018-12-18 上午 11:56
 */
@Service
public class PayTypeServiceImpl implements PayTypeService {

    @Autowired
    private PayTypeMapper payTypeMapper;
    @Value("${paytype-path}")
    private String payTypePath;

    /**
     * 支付方式列表
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResponse<PayType> findPayTypeList(Integer page, Integer rows) {
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(page-1)*rows);
        map.put("pageSize",rows);
        List<PayType> list = payTypeMapper.findPayTypeList(map);
        Integer totalCount = payTypeMapper.getTotalCount();
        return PageResponse.getPageResponse(list, totalCount, page, rows);
    }

    /**
     * 删除 支付方式
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<PayType> deletePayTypeById(Integer id, String address) {
        if (StringUtils.isEmpty(address)) {
            return new ResponseMessage<>(500, "操作异常:删除图片失败,请刷新页面重试");
        }
        //删除文件
        File file = new File(address);
        if (!file.exists()) {
            payTypeMapper.deleteById(id);
            return new ResponseMessage<>(500, "您删除的图片不存在,请刷新页面重试");
        }
        file.delete();
        //删除数据库数据
        payTypeMapper.deleteById(id);
        return new ResponseMessage<>(200, "删除成功");
    }

    /**
     * 上传支付方式
     *
     * @param file
     * @param type
     * @return
     */
    @Override
    public ResponseMessage<PayType> uploadPayType(MultipartFile file, Integer type, String remark) {
        //获取文件名称
        String oFileName = file.getOriginalFilename();
        String fileNameSuffix = oFileName.substring(oFileName.lastIndexOf("."));
        Date date = new Date();
        String nFileName = date.getTime() + fileNameSuffix;
        String path = null;
        try {
            path = payTypePath + nFileName;
            File file1 = new File(payTypePath);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            //保存图片
            OperationImageUtil.saveImage(file,path);
            PayType payType = new PayType();
            payType.setFileName(nFileName);
            payType.setType(type);
            payType.setAddress(path);
            payType.setCreateDate(SimpleDateFormatUtil.dateToString(date,"yyyy-MM-dd hh:mm:ss"));
            payType.setIsUse(2);
            SysUser sysUser = ShiroUtils.getLoginUser();
            payType.setCreateBy(sysUser.getUserId().intValue());
            payType.setRemark(remark);
            payTypeMapper.insert(payType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseMessage<>(500, "系统异常:文件夹创建失败.");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseMessage<>(500, "系统异常:图片保存失败");
        }
        return new ResponseMessage<>(200, "图片保存成功");
    }

    /**
     * 更新支付方式
     * @param payType
     * @return
     */
    @Override
    public ResponseMessage<PayType> updatePayType(PayType payType) {
        if (payType==null){
            return new ResponseMessage<>(500,"参数错误,请刷新重试");
        }
        Integer type = payType.getType();
        if (payType.getIsUse()==1){
            QueryWrapper<PayType> queryWrapper = new QueryWrapper<>();
            Map<String, Object> map = new HashMap<>();
            map.put("type", type);
            map.put("is_use", payType.getIsUse());
            queryWrapper.allEq(map);
            Integer count = payTypeMapper.selectCount(queryWrapper);
            if (count > 0) {
                return new ResponseMessage<>(500, "同类型支付方式只能启用一个");
            }
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        payType.setUpdateDate(sdf.format(date));
        SysUser sysUser = ShiroUtils.getLoginUser();
        payType.setUpdateBy(sysUser.getUserId().intValue());
        payTypeMapper.updateById(payType);
        return new ResponseMessage<>(200,"操作成功");
    }
}
