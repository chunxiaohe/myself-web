package com.sipingsoft.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName(value = "slideshow")
public class Slideshow implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 轮播图片地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 轮播顺序
     */
    @TableField(value = "the_order")
    private Integer theOrder;

    @TableField(value = "millisecond_name")
    private String millisecondName;

    @TableField(value = "real_name")
    private String realName;
    /**
     * 启用(1.启用 2.禁用)
     */
    @TableField(value = "is_use")
    private Integer isUse;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(value = "create_date")
    private String createDate;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_date")
    private String updateDate;

    @TableField(value = "update_by")
    private Integer updateBy;

    /**
     * 创建人
     */
    @TableField(exist = false)
    private String createName;

    /**
     * 更新人
     */
    @TableField(exist = false)
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
     * 获取轮播图片地址
     *
     * @return address - 轮播图片地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置轮播图片地址
     *
     * @param address 轮播图片地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取轮播顺序
     *
     * @return the_order - 轮播顺序
     */
    public Integer getTheOrder() {
        return theOrder;
    }

    /**
     * 设置轮播顺序
     *
     * @param theOrder 轮播顺序
     */
    public void setTheOrder(Integer theOrder) {
        this.theOrder = theOrder;
    }

    /**
     * 获取启用(1.启用 2.禁用)
     *
     * @return is_use - 启用(1.启用 2.禁用)
     */
    public Integer getIsUse() {
        return isUse;
    }

    /**
     * 设置启用(1.启用 2.禁用)
     *
     * @param isUse 启用(1.启用 2.禁用)
     */
    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
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
     * @return create_date
     */
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

    public String getMillisecondName() {
        return millisecondName;
    }

    public void setMillisecondName(String millisecondName) {
        this.millisecondName = millisecondName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
        sb.append(", theOrder=").append(theOrder);
        sb.append(", isUse=").append(isUse);
        sb.append(", remark=").append(remark);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}