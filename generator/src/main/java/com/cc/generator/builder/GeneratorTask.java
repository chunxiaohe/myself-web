package com.cc.generator.builder;

import com.cc.generator.entity.GeneratorREQ;
import com.cc.generator.utils.*;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author He Chunxiao
 * @date 2019-02-22 15:21
 * @desc
 */
public class GeneratorTask {

    /**
     * 生成相应类
     *
     * @param req
     * @return
     */
    public void codeGenerator(GeneratorREQ req) throws IOException, TemplateException {
        //Controller
        if (req.isGeneratorController()) {
            GeneratorControllerUtil.generatorController(req);
        }
        //Service
        if (req.isGeneratorService()) {
            GeneratorServiceUtil.generatorService(req);
        }
        //ServiceImpl
        if (req.isGeneratorServiceImpl()) {
            GeneratorServiceImplUtil.generatorserviceImpl(req);
        }
        //Dao
        if (req.isGeneratorDao()) {
            GeneratorDaoUtil.generatorDao(req);
        }
        //Mapper
        if (req.isGeneratorMapper()) {
            GeneratorMapperUtil.generatorMapper(req);
        }
        //Entity || EntityRES || EntityREQ
        if (req.isGeneratorEntity() || req.isGeneratorEntityRES() || req.isGeneratorEntityREQ()) {
            GeneratorEntityUtil.generatorEntity(req);
        }
        //page
        if (req.isGeneratorPage()) {
            GeneratorPageUtil.generatorPage(req);
        }
    }


}
