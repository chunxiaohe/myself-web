package com.sipingsoft.core.exception;

/**
 * @author HeChunXiao
 * @since 2018-11-09 上午 10:51
 */
public class WithaleafException extends RuntimeException{

    private Integer code;
    private String errorMsg;

    public WithaleafException() {

    }

    public WithaleafException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public WithaleafException(Integer code) {
        this.code = code;
    }

    public WithaleafException(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
