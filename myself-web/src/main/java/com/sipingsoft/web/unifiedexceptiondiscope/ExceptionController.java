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
     * 统一错误处理
     * @return 错误提示消息
     */
    @ExceptionHandler(WithaleafException.class)
    @ResponseBody
    public Map<String, Object> withaleafExceptionDiscope( WithaleafException e) {
        Map<String,Object> map = new HashMap<>(3);
        map.put("code",e.getCode());
        map.put("errorMsg",e.getErrorMsg());
        return map;
    }
}
