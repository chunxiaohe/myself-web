package com.sipingsoft.back.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/12
*/
@Data
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
    private Date createDate;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_date")
    private Date updateDate;

    @TableField(value = "update_by")
    private Date updateBy;

    private static final long serialVersionUID = 1L;
}