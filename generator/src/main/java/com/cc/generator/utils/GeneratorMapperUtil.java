package com.cc.generator.utils;

import com.cc.generator.entity.GeneratorREQ;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author He Chunxiao
 * @date 2019-02-22 15:46
 * @desc
 */
public class GeneratorMapperUtil {

    /**
     * CreateMapper
     */
    public static void generatorMapper(GeneratorREQ req) throws IOException, TemplateException {
        // 生成Mapper填充数据
        Map<String, Object> mapperData = BaseDataUtil.getBaseMap(req);
        mapperData.put("TableName", req.getTableName());
        mapperData.put("InsertProperties", GeneratorUtil.generateMapperInsertProperties(req.getMultipleSelection()));
        mapperData.put("Id", "#{id,jdbcType=INTEGER}");
        mapperData.put("limit", "#{page.startNo},#{page.pageSize}");
        mapperData.put("orgCode", "#{orgCode}");
        mapperData.put("langFlag", "#{langFlag}");
        // 单表
        mapperData.put("ColumnMap", GeneratorUtil.generateMapperColumnMap(req.getTableName(), req.getMultipleSelection()));
        mapperData.put("ResultMap", GeneratorUtil.generateMapperResultMap(req.getMultipleSelection()));
        mapperData.put("Association", "");
        mapperData.put("Collection", "");
        mapperData.put("InsertBatchValues", GeneratorUtil.generateMapperInsertBatchValues(req.getMultipleSelection(), StringUtil.firstToLowerCase(req.getClassName())));
        mapperData.put("InsertValues", GeneratorUtil.generateMapperInsertValues(req.getMultipleSelection()));
        mapperData.put("UpdateProperties", GeneratorUtil.generateMapperUpdateProperties(req.getMultipleSelection()));
        mapperData.put("Joins", "");
        mapperData.put("UpdateParam", GeneratorUtil.generateUpdateParam(req.getMultipleSelection()));

        StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
        filePath.append("mapper");
        filePath.append(File.separator);
        filePath.append("xml");
        filePath.append(File.separator);
        String fileName = StringUtil.firstToUpperCase(req.getClassName()) + "Mapper.xml";
        // 生成Mapper文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_MAPPER, mapperData, filePath + fileName, filePath.toString());
    }
}
