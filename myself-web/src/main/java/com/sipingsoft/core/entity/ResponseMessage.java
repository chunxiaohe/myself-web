package com.sipingsoft.core.entity;

import java.util.List;

public class ResponseMessage<T> {

	private String message;
	
	private List<T> data;
	
	

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(List<T> data) {
		super();
		this.data = data;
	}

	public ResponseMessage(String message, List<T> data) {
		super();
		this.message = message;
		this.data = data;
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
