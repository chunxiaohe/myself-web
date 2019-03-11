package com.cc.generator.entity;

import com.cc.generator.utils.StringUtil;

import java.io.Serializable;

/**
 * Author GreedyStar
 * Date   2018/4/19
 */
public class ColumnInfo implements Serializable {
    private String columnName; // 列名
    private String jdbcTypeName;// 类型名称
    private int type; // 类型代码
    private String propertyName; // 属性名
    private boolean isPrimaryKey; // 是否主键
    private String annotation;//注释
    private String javaType;
    public ColumnInfo() {

    }

    public ColumnInfo(String columnName, int type, String annotation) {
        this.columnName = columnName;
        this.type = type;
        this.annotation = annotation;
    }

    public ColumnInfo(String columnName, int type, boolean isPrimaryKeyM, String annotation,String jdbcTypeName) {
        this.columnName = columnName;
        this.type = type;
        this.propertyName = StringUtil.columnName2PropertyName(columnName);
        this.isPrimaryKey = isPrimaryKeyM;
        this.annotation = annotation;
        this.jdbcTypeName = jdbcTypeName;
    }

    public ColumnInfo(String columnName, int type, boolean isPrimaryKeyM) {
        this.columnName = columnName;
        this.type = type;
        this.propertyName = StringUtil.columnName2PropertyName(columnName);
        this.isPrimaryKey = isPrimaryKeyM;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getJdbcTypeName() {
        return jdbcTypeName;
    }

    public void setJdbcTypeName(String jdbcTypeName) {
        this.jdbcTypeName = jdbcTypeName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "columnName='" + columnName + '\'' +
                ", jdbcTypeName='" + jdbcTypeName + '\'' +
                ", type=" + type +
                ", propertyName='" + propertyName + '\'' +
                ", isPrimaryKey=" + isPrimaryKey +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
