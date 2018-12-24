package com.sipingsoft.core.entity;

import java.util.List;

/**
 * 返回信息
 * @author He Chunxiao
 * @param <T>
 */
public class ResponseMessage<T> {

    private Integer code;

	private String message;
	
	private List<T> data;
	


	public ResponseMessage() {
		super();
	}

	public ResponseMessage(List<T> data) {
		super();
		this.data = data;
	}

	public ResponseMessage(Integer code, String message, List<T> data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessage(Integer code, List<T> data) {
        this.code = code;
        this.data = data;
    }

    public ResponseMessage(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ReponseMessage [message=" + message + ", data=" + data + "]";
	}
	
	
}
