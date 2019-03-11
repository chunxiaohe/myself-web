package com.cc.generator.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author He Chunxiao
 * @date 2019-02-22 10:05
 * @desc
 */
@Setter
@Getter
public class GeneratorREQ implements Serializable {

    /**
     * 类名
     */
    private String className;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 类描述
     */
    private String classAnnotation;
    /**
     * 包路径
     */
    private String packagePath;
    /**
     * 是否生成Controller
     */
    private boolean generatorController;
    /**
     * 是否生成服务类接口
     */
    private boolean generatorService;
    /**
     * 是否生成服务类实现
     */
    private boolean generatorServiceImpl;
    /**
     * 是否生成Dao
     */
    private boolean generatorDao;
    /**
     * 是否生成xml
     */
    private boolean generatorMapper;
    /**
     * 是否生成实体类
     */
    private boolean generatorEntity;
    /**
     * 是否生成请求参数实体
     */
    private boolean generatorEntityREQ;
    /**
     * 是否生成返回实体
     */
    private boolean generatorEntityRES;
    /**
     * 是否生成页面
     */
    private boolean generatorPage;
    /**
      *  需要生成的字段集合
     */
    private List<ColumnInfo> multipleSelection;

}
