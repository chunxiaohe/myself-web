package ${BasePackageName}${ControllerPackageName};

import ${BasePackageName}bean.${EntityPackageName}.${ClassName};
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import com.sipingsoft.admin.web.sys.bean.req.*;
import com.sipingsoft.admin.web.sys.bean.res.${ClassName}SelectRES;
import com.sipingsoft.common.entity.PageRequest;
import com.sipingsoft.common.entity.PageResponse;
import com.sipingsoft.common.entity.Response;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @date  ${Date}
 * @desc ${Desc}控制类
 */
@RestController
@RequestMapping(value = "/admin/${EntityName}")
@ConditionalOnProperty(name = "smartone.admin.enable", havingValue = "true", matchIfMissing = true)
public class ${ClassName}Controller extends BaseController{

    @Autowired
    private ${ClassName}Service ${EntityName}Service;

    /**
    * 分页查询数据
    *
    */
    @RequiresPermissions(value = {"sys:${EntityName}:add", "sys:${EntityName}:update", "sys:${EntityName}:delete", "sys:${EntityName}:view"}, logical = Logical.OR)
    @GetMapping("/page")
    public Response listByPage(PageRequest pageRequest, ${ClassName}SelectREQ selectREQ) {
        selectREQ.setOrgCode(getOrgCode());
        PageResponse<${ClassName}> pageResponse = ${EntityName}Service.listByPage(pageRequest, selectREQ);
        if (CollectionUtils.isEmpty(pageResponse.getRecords())) {
            return  new Response().successWithData(pageResponse);
        }
        List<${ClassName}SelectRES> records = beanMapper.mapList(pageResponse.getRecords(),${ClassName}SelectRES.class);
        PageResponse<${ClassName}SelectRES> response = new PageResponse<>();
        response.setRecords(records);
        response.setTotal(pageResponse.getTotal());
        return new Response().successWithData(response);
    }

    /**
    * 添加数据
    *
    */
    @RequiresPermissions("sys:${EntityName}:add")
    @PostMapping
    public Response add(@RequestBody ${ClassName}AddREQ ${EntityName}AddREQ) {
        ${ClassName} ${EntityName} = beanMapper.map(${EntityName}AddREQ, ${ClassName}.class);
        ${EntityName}.setOrgCode(getOrgCode());
        Integer id = ${EntityName}Service.insert(${EntityName});
        return new Response().successWithData(id);
    }


    /**
    * 根据id查询详情
    *
    * @param id
    * @return
    */
    @RequiresPermissions(value = {"sys:${EntityName}:add", "sys:${EntityName}:update", "sys:${EntityName}:delete", "sys:${EntityName}:view"}, logical = Logical.OR)
    @GetMapping("/{id}")
    public Response query(@PathVariable Integer id) {
        ${ClassName} ${EntityName} = ${EntityName}Service.selectByPk(id);
        if (Objects.isNull(${EntityName})) {
        return new Response().success();
        }
        ${ClassName}SelectRES res = beanMapper.map(${EntityName}, ${ClassName}SelectRES.class);
        return new Response().successWithData(res);
    }

    /**
    * 根据id删除数据  物理删除
    */
    @RequiresPermissions("sys:${EntityName}:delete")
    @DeleteMapping
    public Response delete(Integer id) {
        ${EntityName}Service.deleteByPk(id);
        return new Response().success();
    }

    /**
    * 根据id批量删除  物理删除
    *
    */
    @RequiresPermissions("sys:${EntityName}:delete")
    @DeleteMapping("/batch")
    public Response deleteBatch(@RequestBody ${ClassName}DeleteBatchREQ deleteBatchREQ) {
        ${EntityName}Service.deleteByPks(deleteBatchREQ.getIds());
        return new Response().success();
    }

    /**
    * 选择性更新
    *
    */
    @RequiresPermissions("sys:${EntityName}:update")
    @PutMapping("/selective")
    public Response update(@RequestBody ${ClassName}UpdateREQ updateREQ){
        ${ClassName} ${EntityName} = beanMapper.map(updateREQ,${ClassName}.class);
        ${EntityName}Service.updateByPkSelective(${EntityName});
        return new Response().success();
    }

}
