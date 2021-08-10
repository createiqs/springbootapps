package com.createiq.pw.model;

public class ResponBean {

	private int satusCode;
	private String msg;

	public ResponBean(int satusCode, String msg) {
		super();
		this.satusCode = satusCode;
		this.msg = msg;
	}

	public ResponBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSatusCode() {
		return satusCode;
	}

	public void setSatusCode(int satusCode) {
		this.satusCode = satusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
