package ${BasePackageName}${ServicePackageName}.impl;

import ${BasePackageName}${DaoPackageName}.${ClassName}Mapper;
import ${BasePackageName}bean.${EntityPackageName}.${ClassName};
import ${BasePackageName}service.${ClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date  ${Date}
 * @desc ${Desc}serviceImpl
 */
@Service
public class ${ClassName}ServiceImpl  implements ${ClassName}Service {

    @Autowired
    private ${ClassName}Mapper ${EntityName}Mapper;


}
