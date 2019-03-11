package com.cc.generator.utils;

import com.cc.generator.entity.GeneratorREQ;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author He Chunxiao
 * @date 2019-02-22 15:44
 * @desc
 */
public class GeneratorServiceUtil {

    /**
     * CreateService
     */
    public static String generatorService(GeneratorREQ req) throws IOException, TemplateException {
        // 生成Service填充数据
        Map<String, Object> serviceData = BaseDataUtil.getBaseMap(req);
        StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
        filePath.append("service");
        filePath.append(File.separator);
        String fileName = StringUtil.firstToUpperCase(req.getClassName()) + "Service.java";
        // 生成Service文件
        return FileUtil.generateToJava(FreemarketConfigUtils.TYPE_SERVICE, serviceData, filePath + fileName, filePath.toString());
    }
}
