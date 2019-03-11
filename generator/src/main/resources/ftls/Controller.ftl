package ${BasePackageName}${ControllerPackageName};

import ${BasePackageName}bean.${EntityPackageName}.${ClassName};
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @date  ${Date}
 * @desc ${Desc}控制类
 */
@RestController
@ConditionalOnProperty(name = "smartone.admin.enable", havingValue = "true", matchIfMissing = true)
public class ${ClassName}Controller extends BaseController{

    @Autowired
    private ${ClassName}Service ${EntityName}Service;

}
