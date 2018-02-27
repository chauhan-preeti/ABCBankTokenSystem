package org.test.boot.http.model;

public class  BaseResponse <T>{
	public enum Status{
		SUCCESS,ERROR,FAILURE
	}
	
	private Status status;
	private String message;
	private T details;
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getDetails() {
		return details;
	}
	public void setDetails(T details) {
		this.details = details;
	}
	
}
