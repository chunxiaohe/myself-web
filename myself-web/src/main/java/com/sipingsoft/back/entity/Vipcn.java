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
@TableName(value = "vipcn")
public class Vipcn implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公众号二维码地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 是否启用(1.启用 2.禁用)
     */
    @TableField(value = "is_use")
    private Boolean isUse;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_date")
    private Date updateDate;

    @TableField(value = "update_by")
    private Integer updateBy;

    private static final long serialVersionUID = 1L;
}