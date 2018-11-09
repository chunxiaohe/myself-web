package com.sipingsoft.web.unifiedexceptiondiscope;


import com.sipingsoft.core.exception.WithaleafException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理类
 * ControllerAdvice 开启全局异常处理
 *
 * @author HeChunXiao
 * @since 2018-11-09 上午 10:03
 *
 */

@ControllerAdvice
public class ExceptionController {


    /**
     * 统一错误处理测试
     * @return
     */
    @ExceptionHandler(WithaleafException.class)
    @ResponseBody
    public Map<String, Object> withaleafExceptionDiscope( WithaleafException e) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("errorMsg",e.getErrorMsg());
        return map;
    }
}
