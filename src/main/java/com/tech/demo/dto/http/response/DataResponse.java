package com.tech.demo.dto.http.response;



public class DataResponse implements RestResponse {
	
	int status;
	
	String message;
	
	Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

	public DataResponse(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public DataResponse() {
		super();
	}
	
	
	

}
