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
public class GeneratorServiceImplUtil {

    /**
     * CreateServiceImpl
     */
    public static void generatorserviceImpl(GeneratorREQ req) throws IOException, TemplateException {
        // 生成ServiceImpl填充数据
        Map<String, Object> serviceData = BaseDataUtil.getBaseMap(req);
        StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
        filePath.append("service");
        filePath.append(File.separator);
        filePath.append("impl");
        filePath.append(File.separator);
        String fileName = StringUtil.firstToUpperCase(req.getClassName()) + "ServiceImpl.java";
        // 生成Service文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_SERVICEIMPL, serviceData, filePath + fileName, filePath.toString());
    }
}
