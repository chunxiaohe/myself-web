package com.cc.generator.utils;

import com.cc.generator.entity.GeneratorREQ;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author He Chunxiao
 * @date 2019-02-25 14:50
 * @desc
 */
public class BaseDataUtil {

    public static Map<String,Object> getBaseMap(GeneratorREQ req){
        Map<String,Object> baseData = new HashMap<>();
        String BasePackageName = req.getPackagePath().replace("/",".");
        baseData.put("BasePackageName", BasePackageName);
        baseData.put("ServicePackageName", "service");
        baseData.put("EntityPackageName", "entity");
        baseData.put("DaoPackageName","dao");
        baseData.put("Date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        baseData.put("ClassName",  StringUtil.firstToUpperCase(req.getClassName()));
        baseData.put("Desc",req.getClassAnnotation());
        baseData.put("EntityName", StringUtil.firstToLowerCase(req.getClassName()));
        return baseData;
    }

    public static StringBuilder getBasePath(String tableName){
        StringBuilder filePath = new StringBuilder();
        filePath.append(System.getProperty("user.home"));
        filePath.append(File.separator);
        filePath.append("CodeGenerator");
        filePath.append(File.separator);
        filePath.append("code");
        filePath.append(File.separator);
        filePath.append(tableName);
        filePath.append(File.separator);
        return filePath;
    }
}
