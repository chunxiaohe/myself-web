package com.cc.core.exception;

/**
 * 验证码异常错误类
 * @author HeChunXiao
 * @since 2018-11-02 下午 2:26
 */
public class RandomCodeException extends Exception {

    public RandomCodeException() {
        super();
    }

    public RandomCodeException(String message) {
        super(message);
    }

    public RandomCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RandomCodeException(Throwable cause) {
        super(cause);
    }

    protected RandomCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
