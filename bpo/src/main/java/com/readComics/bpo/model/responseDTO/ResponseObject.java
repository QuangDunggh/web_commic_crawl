package com.readComics.bpo.model.responseDTO;

public class ResponseObject {
	
	private String error;
	
	private String message;
	
	private Object data;
	
	public ResponseObject() {
		
	}
	
	public ResponseObject(String error, String message, Object data) {
		
		this.error = error;
		
		this.message = message;
		
		this.data = data;
		
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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
		return "ResponseDTO [error=" + error + ", message=" + message + ", data=" + data + "]";
	}
	
	

}
