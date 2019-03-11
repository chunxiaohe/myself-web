package com.cc.generator.utils;

import com.cc.generator.entity.GeneratorREQ;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author He Chunxiao
 * @date 2019-02-22 15:40
 * @desc
 */
public class GeneratorControllerUtil {

    /**
     * CreateController
     */
    public static void generatorController(GeneratorREQ req) throws IOException, TemplateException {
        Map<String, Object> controllerData = BaseDataUtil.getBaseMap(req);
        controllerData.put("ControllerPackageName", "controller");
        StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
        filePath.append("controller");
        filePath.append(File.separator);
        String fileName = StringUtil.firstToUpperCase(req.getClassName()) + "Controller.java";
        // 生成Controller文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_CONTROLLER, controllerData, filePath + fileName, filePath.toString());
    }

}
