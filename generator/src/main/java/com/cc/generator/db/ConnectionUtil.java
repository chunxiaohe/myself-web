package com.cc.generator.db;


import com.cc.generator.entity.ColumnInfo;
import com.cc.generator.entity.ResponseTbale;
import com.cc.generator.entity.TableListEntity;
import com.cc.generator.utils.ColumnTypeUtil;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author GreedyStar
 * Date   2018/4/19
 */
public class ConnectionUtil {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * 初始化数据库连接
     *
     * @return
     */
    public boolean initConnection(String dbType, String dbUrl, String dbUsername, String dbPassword) {
        try {
            Class.forName(DriverFactory.getDriver(dbType));
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取表结构数据
     *
     * @param tableSchema 数据库名字
     * @return 包含表结构数据的列表
     */
    public ResponseTbale getMetaData(String tableSchema, String tableName, Integer pageSize, Integer pageNo) throws Exception {
        ResponseTbale responseTbale = new ResponseTbale();
        List<TableListEntity> listEntities = new ArrayList<>();
        statement = connection.createStatement();
        String sql;
        String sqlCount;
        if (StringUtils.isEmpty(tableName)) {
            sql = "SELECT TABLE_NAME,TABLE_COMMENT,CREATE_TIME FROM information_schema.TABLES  WHERE TABLE_SCHEMA ='" + tableSchema + "'";
            sqlCount  = "select COUNT(*) FROM TABLES  WHERE TABLE_SCHEMA ='" + tableSchema + "'";
        } else {
            tableName = String.format("%%%s%%", tableName);
            sql = "SELECT TABLE_NAME,TABLE_COMMENT,CREATE_TIME FROM information_schema.TABLES  WHERE TABLE_SCHEMA ='" + tableSchema + "' AND TABLE_NAME LIKE '" + tableName + "'";
            sqlCount  = "SELECT COUNT(*) FROM TABLES  WHERE TABLE_SCHEMA ='" + tableSchema + "' AND TABLE_NAME LIKE '" + tableName + "'";
        }
        int pageStart = (pageNo-1)*pageSize;
        sql = sql+"LIMIT "+pageStart+","+pageSize;
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String tableName1 = resultSet.getString(1);
            String tableAnnotation = resultSet.getString(2);
            String tableCreateDate = resultSet.getString(3);
            TableListEntity tableListEntity = new TableListEntity();
            tableListEntity.setTableAnnotation(tableAnnotation);
            tableListEntity.setTableCreateDate(tableCreateDate);
            tableListEntity.setTableName(tableName1);
            tableListEntity.setTableSchema(tableSchema);
            listEntities.add(tableListEntity);
        }
        resultSet = statement.executeQuery(sqlCount);
        while (resultSet.next()){
            Integer count = resultSet.getInt(1);
            responseTbale.setCount(count);
        }
        statement.close();
        resultSet.close();
        responseTbale.setListEntities(listEntities);
        return responseTbale;
    }

    /**
     * 获取对应表的字段信息
     *
     * @param tableName 表名
     * @return 包含表结构数据的列表
     */
    public List<ColumnInfo> getMetaDataForTable(String tableName, String tableSchema) throws Exception {
        List<ColumnInfo> columnInfos = new ArrayList<>();
        statement = connection.createStatement();
        String sql = " SELECT TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME,COLUMN_KEY, DATA_TYPE,COLUMN_COMMENT FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + tableSchema + "' AND TABLE_NAME = '" + tableName + "'";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int type = -1;
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                if (i >= 3) {
                    type = ColumnTypeUtil.getDataType(resultSet.getString(5).toLowerCase());
                }
            }
            String columnName = resultSet.getString(3);
            boolean isKey = false;
            if (!StringUtils.isEmpty(resultSet.getString(4)) && "PRI".equals(resultSet.getString(4))) {
                isKey = true;
            }
            String desc = resultSet.getString(6);
            String jdbcTypeName = resultSet.getString(5);
            ColumnInfo info = new ColumnInfo(columnName, type, isKey, desc,jdbcTypeName);
            columnInfos.add(info);
        }
        statement.close();
        resultSet.close();
        return columnInfos;
    }

}
