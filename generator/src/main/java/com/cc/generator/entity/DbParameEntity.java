package com.cc.generator.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author He Chunxiao
 * @date 2019-02-20 11:51
 * @desc
 */
@Setter
@Getter
public class DbParameEntity implements Serializable {
    /**
     * 数据类类型
     */
    private String dbType;
    /**
     * 数据库url
     */
    private String dbUrl;
    /**
     * 数据库username
     */
    private String dbUsername;
    /**
     * 数据库密码
     */
    private String dbPassword;
    /**
     * 数据库名称
     */
    private String dbName;
    /**
     * 数据库系统的url
     */
    private String sysUrl;

}
