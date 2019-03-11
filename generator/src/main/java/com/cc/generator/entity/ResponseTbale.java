package com.cc.generator.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author He Chunxiao
 * @date 2019-02-20 15:34
 * @desc
 */
@Getter
@Setter
public class ResponseTbale {
    /**
     * 表数据
     */
    private List<TableListEntity> listEntities;
    /**
     * 数据条目数
     */
    private Integer count;


}
