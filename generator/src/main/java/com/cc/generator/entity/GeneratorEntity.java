package com.cc.generator.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author He Chunxiao
 * @date 2019-02-20 11:13
 * @desc
 */
@Setter
@Getter
public class GeneratorEntity implements Serializable {
    /**
     * 表名
     */
    private String tableName;
    /**
     * Controller
     */
    private Boolean generatorController;
    /**
     * Service
     */
    private Boolean generatorService;
    /**
     * serviceImpl
     */
    private Boolean generatorServiceImpl;
    /**
     * Dao
     */
    private Boolean generatorDao;
    /**
     * Mapper
     */
    private Boolean generatorMapper;
    /**
     * entity
     */
    private Boolean generatorEntity;
    /**
     * page
     */
    private Boolean generatorPage;
    /**
     * 类名前缀
     */
    private String multipleSelection;

}
