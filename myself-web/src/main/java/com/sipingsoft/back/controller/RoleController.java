package com.sipingsoft.back.controller;

import com.sipingsoft.core.entity.ResponseMessage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeChunXiao
 * @since 2018-11-01 上午 10:07
 */
@RestController
public class RoleController {

    @PostMapping("/page/backend/addRole")
    @RequiresPermissions("page:backend:addRole")
    public ResponseMessage addRole(){
        return new ResponseMessage(200,"新增成功",null);
    }
}
