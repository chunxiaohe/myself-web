package com.cc.generator.utils;

import com.cc.generator.entity.GeneratorREQ;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author He Chunxiao
 * @date 2019-02-22 15:45
 * @desc
 */
public class GeneratorDaoUtil {

    /**
     * CreateDao
     */
    public static String generatorDao(GeneratorREQ req) throws IOException, TemplateException {
        // 生成Dao填充数据
        Map<String, Object> daoData = BaseDataUtil.getBaseMap(req);
        StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
        filePath.append("mapper");
        filePath.append(File.separator);
        String fileName = StringUtil.firstToUpperCase(req.getClassName()) + "Mapper.java";
        // 生成dao文件
        return FileUtil.generateToJava(FreemarketConfigUtils.TYPE_DAO, daoData, filePath + fileName,filePath.toString());
    }
}
