package com.sipingsoft.back.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/12
*/
@Data
public class ArticleClass implements Serializable {
    /**
	* 
	*/
    private Integer id;

    /**
	* 分类名称
	*/
    private String typeName;

    /**
	* 备注
	*/
    private String remark;

    /**
	* 是否启用(1.启用  2.禁用)
	*/
    private Boolean isUse;

    /**
	* 创建时间
	*/
    private Date createDate;

    /**
	* 
	*/
    private Integer createBy;

    /**
	* 
	*/
    private Date updateDate;

    /**
	* 
	*/
    private Integer updateBy;

    private static final long serialVersionUID = 1L;
}