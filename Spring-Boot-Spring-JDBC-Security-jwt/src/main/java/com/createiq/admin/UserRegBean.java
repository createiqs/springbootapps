package com.createiq.admin;

import java.util.List;

public class UserRegBean {
	private String username;
	private String password;
	private List<String> roles;

	public UserRegBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegBean(String username, String password, List<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserRegBean [username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}

}
