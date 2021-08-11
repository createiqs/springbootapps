package com.createiq.pw.domin;

public class ResponseBean {
	private int status;
	private Object result;
	public ResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseBean(int status, Object result) {
		super();
		this.status = status;
		this.result = result;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	

}
