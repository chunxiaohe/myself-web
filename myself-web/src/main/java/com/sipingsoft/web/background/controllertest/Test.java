package com.sipingsoft.web.background.controllertest;

import com.sipingsoft.web.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HeChunXiao
 * @since 2018-11-09 上午 11:31
 */
@Controller
public class Test {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 测试统一异常处理 已经请求拦截
     * 返回给前端的字符串乱码===>>produces = "text/html;charset=UTF-8"
     * @param id
     * @return
     */
    @GetMapping(value = "/page/wechat/{id}",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String wechat(@PathVariable(name = "id") Integer id){
        return sysMenuService.errMsg(id);
    }
}
