package com.cc.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.core.util.FormatDateUtil;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@TableName(value = "pay_type")
public class PayType implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付图片的地址
     */
    @TableField(value = "address")
    private String address;

    @TableField(value = "create_date")
    private String createDate;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_date")
    private String updateDate;

    @TableField(value = "update_by")
    private Integer updateBy;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 1.微信 2.支付宝
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 文件名字
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 1.启用 2.禁用
     */
    @TableField(value = "is_use")
    private Integer isUse;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 更新人姓名
     */
    private String updateName;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取支付图片的地址
     *
     * @return address - 支付图片的地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置支付图片的地址
     *
     * @param address 支付图片的地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return create_date
     */
    @JsonSerialize(using = FormatDateUtil.class)
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * @return update_date
     */
    @JsonSerialize(using = FormatDateUtil.class)
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return update_by
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取1.微信 2.支付宝
     *
     * @return type - 1.微信 2.支付宝
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1.微信 2.支付宝
     *
     * @param type 1.微信 2.支付宝
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取文件名字
     *
     * @return file_name - 文件名字
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名字
     *
     * @param fileName 文件名字
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取1.启用 2.禁用
     *
     * @return is_use - 1.启用 2.禁用
     */
    public Integer getIsUse() {
        return isUse;
    }

    /**
     * 设置1.启用 2.禁用
     *
     * @param isUse 1.启用 2.禁用
     */
    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", address=").append(address);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", remark=").append(remark);
        sb.append(", type=").append(type);
        sb.append(", fileName=").append(fileName);
        sb.append(", isUse=").append(isUse);
        sb.append("]");
        return sb.toString();
    }
}