package com.cc.generator.controller;

import com.cc.generator.builder.GeneratorTask;
import com.cc.generator.db.ConnectionUtil;
import com.cc.generator.entity.ColumnInfo;
import com.cc.generator.entity.DbParameEntity;
import com.cc.generator.entity.GeneratorREQ;
import com.cc.generator.entity.ResponseTbale;
import com.cc.generator.utils.BaseDataUtil;
import com.cc.generator.utils.FileUtil;
import com.cc.generator.utils.TypeUtil;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author He Chunxiao
 * @date 2019-02-20 11:11
 * @desc
 */
public class Application {

    /**
     * 获取数据库下的表列表
     * @param parameEntity 数据库连接信息
     * @param tableName 表名
     * @param pageSiZe 分页参数
     * @param pageNo    分页参数
     * @return
     * @throws Exception
     */
    public ResponseTbale getDbTable(DbParameEntity parameEntity, String tableName, Integer pageSiZe, Integer pageNo) throws Exception {
        //创建数据库连接
        ConnectionUtil util = new ConnectionUtil();
        ResponseTbale responseTbale = new ResponseTbale();
        if (util.initConnection(parameEntity.getDbType(), parameEntity.getSysUrl(), parameEntity.getDbUsername(), parameEntity.getDbPassword())) {
            //从数据库的系统表获取对应数据下的表列表
            responseTbale = util.getMetaData(parameEntity.getDbName(), tableName, pageSiZe, pageNo);
        }
        return responseTbale;
    }

    /**
     * 获取对应表的字段信息
     * @param parameEntity 数据库的连接信息
     * @param tableSchema 数据库名
     * @param tabelName 表名
     * @return
     * @throws Exception
     */
    public List<ColumnInfo> getTableInfo(DbParameEntity parameEntity, String tableSchema, String tabelName) throws Exception {
        ConnectionUtil util = new ConnectionUtil();
        List<ColumnInfo> columnInfos = new ArrayList<>();
        if (util.initConnection(parameEntity.getDbType(), parameEntity.getSysUrl(), parameEntity.getDbUsername(), parameEntity.getDbPassword())) {
            columnInfos = util.getMetaDataForTable(tabelName, tableSchema);
            columnInfos.forEach(columnInfo -> {
                String javaType = TypeUtil.parseTypeFormSqlType(columnInfo.getType());
                columnInfo.setJavaType(javaType);
            });
        }
        return columnInfos;
    }

    /**
     * 文件生成
     *
     * @param req 是否生成相应文件的实体类
     */
    public void createFile(GeneratorREQ req) throws IOException, TemplateException {
        //生成文件
        new GeneratorTask().codeGenerator(req);
    }


    /**
     * 文件压缩
     *
     * @param tableName 表名
     * @throws IOException
     */
    public void compress(String tableName) throws IOException {
        String basePath = BaseDataUtil.getBasePath(tableName).toString();
        String compressPath = basePath.substring(0, basePath.indexOf("code" + File.separator)) + tableName + ".zip";
        FileUtil.compress(basePath, compressPath);
    }

    /**
     * 文件下载
     *
     * @param response
     * @param tableName 表名
     */
    public void downloadFile(HttpServletResponse response, String tableName) {
        String basePath = BaseDataUtil.getBasePath(tableName).toString();
        String downloadPath = basePath.substring(0, basePath.indexOf("code")) + tableName + ".zip";
        FileUtil.downLoadZip(response, downloadPath, tableName + ".zip");
    }

}
