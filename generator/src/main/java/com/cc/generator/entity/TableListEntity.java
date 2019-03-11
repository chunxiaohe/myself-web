package com.cc.generator.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author He Chunxiao
 * @date 2019-02-20 11:35
 * @desc
 */
@Getter
@Setter
public class TableListEntity implements Serializable {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表备注
     */
    private String tableAnnotation;
    /**
     * 表创建时间
     */
    private String tableCreateDate;
    /**
     * 数据库名称
     */
    private String tableSchema;


}
