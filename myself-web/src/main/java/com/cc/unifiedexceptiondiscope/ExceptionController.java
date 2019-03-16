package com.cc.unifiedexceptiondiscope;


import com.cc.core.entity.ResponseMessage;
import com.cc.core.exception.RandomCodeException;
import com.cc.core.exception.WithaleafException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理类
 * ControllerAdvice 开启全局异常处理
 *
 * @author HeChunXiao
 * @since 2018-11-09 上午 10:03
 */

@ControllerAdvice
public class ExceptionController {


    /**
     * 统一错误处理
     *
     * @return 错误提示消息
     */
    @ExceptionHandler(WithaleafException.class)
    @ResponseBody
    public Map<String, Object> withaleafExceptionDiscope(WithaleafException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("errorMsg", e.getErrorMsg());
        return map;
    }

    @ExceptionHandler(RandomCodeException.class)
    @ResponseBody
    public ResponseMessage codeException(RandomCodeException e) {
        return new ResponseMessage(500, e.getMessage());
    }

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseBody
    public ResponseMessage fileException(FileNotFoundException e) {
        return new ResponseMessage(500, "系统异常,请刷新页面重试:" + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMessage exception(Exception e) {
        return new ResponseMessage(500, "系统异常:" + e.getMessage());
    }
}
