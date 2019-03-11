package ${BasePackageName}${ServicePackageName}.impl;

import ${BasePackageName}${DaoPackageName}.${ClassName}Mapper;
import ${BasePackageName}bean.${EntityPackageName}.${ClassName};
import ${BasePackageName}service.${ClassName}Service;
import com.sipingsoft.common.base.mapper.CrudMapper;
import com.sipingsoft.common.base.service.impl.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date  ${Date}
 * @desc ${Desc}serviceImpl
 */
@Service
public class ${ClassName}ServiceImpl extends BaseCrudServiceImpl<${ClassName}, Integer> implements ${ClassName}Service {

    @Autowired
    private ${ClassName}Mapper ${EntityName}Mapper;

    @Override
    protected CrudMapper<${ClassName}, Integer> getCrudMapper() {
        return ${EntityName}Mapper;
    }

}
