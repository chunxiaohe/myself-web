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
public class GeneratorPageUtil {

    /**
     * CreatePage
     */
    public static void generatorPage(GeneratorREQ req) throws IOException, TemplateException {
        // 生成view填充数据
        Map<String, Object> viewData = BaseDataUtil.getBaseMap(req);
        StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
        filePath.append("view");
        filePath.append(File.separator);
        String fileName = StringUtil.firstToUpperCase(req.getClassName()) + ".vue";
        // 生成view文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_VIEW, viewData, filePath + fileName, filePath.toString());
    }
}
