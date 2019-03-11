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
public class GeneratorEntityUtil {

    /**
     * CreateEntity
     */
    public static void generatorEntity(GeneratorREQ req) throws IOException, TemplateException {
        // 生成Entity填充数据
        Map<String, Object> entityData = BaseDataUtil.getBaseMap(req);
        // 单表关系
        entityData.put("Properties", GeneratorUtil.generateEntityProperties(req.getMultipleSelection(), 1));
        entityData.put("Methods", GeneratorUtil.generateEntityMethods(req.getMultipleSelection()));
        if (req.isGeneratorEntity()) {
            StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
            filePath.append("bean");
            filePath.append(File.separator);
            filePath.append("entity");
            filePath.append(File.separator);
            String fileName = StringUtil.firstToUpperCase(req.getClassName()) + ".java";
            // 生成Entity文件
            FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, entityData, filePath + fileName, filePath.toString());
        }
        if (req.isGeneratorEntityRES()) {
            StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
            filePath.append("bean");
            filePath.append(File.separator);
            filePath.append("res");
            filePath.append(File.separator);
            String fileName = StringUtil.firstToUpperCase(req.getClassName()) + "SelectRES.java";
            //生成RES文件
            FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, entityData, filePath + fileName, filePath.toString());
        }
        if (req.isGeneratorEntityREQ()) {
            StringBuilder filePath = BaseDataUtil.getBasePath(req.getTableName());
            filePath.append("bean");
            filePath.append(File.separator);
            filePath.append("req");
            filePath.append(File.separator);
            //生成SelectREQ文件
            String fileNameSelect = StringUtil.firstToUpperCase(req.getClassName()) + "SelectREQ.java";
            FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, entityData, filePath + fileNameSelect, filePath.toString());
            //生成AddREQ文件
            String fileNameAdd = StringUtil.firstToUpperCase(req.getClassName()) + "AddREQ.java";
            FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, entityData, filePath + fileNameAdd, filePath.toString());
            //生成UpdateREQ文件
            String fileNameUpdate = StringUtil.firstToUpperCase(req.getClassName()) + "UpdateREQ.java";
            FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, entityData, filePath + fileNameUpdate, filePath.toString());
        }

    }

}
