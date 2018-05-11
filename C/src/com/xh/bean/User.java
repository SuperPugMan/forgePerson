package com.xh.bean;

import java.io.Serializable;

public class User implements Serializable{
	
	private Integer id;
	private String loginName;
	private String userName;
	private String password;
	private Integer sex;
	private String identityCode;
	private String email;
	private String mobile;
	private Integer type;
	
	
	public User() {
		super();
	}


	public User(int id, String loginName, String userName, String password,
			int sex, String identityCode, String email, String mobile, int type) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}


	public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getIdentityCode() {
		return identityCode;
	}


	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Integer getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", userName="
				+ userName + ", password=" + password + ", sex=" + sex
				+ ", identityCode=" + identityCode + ", email=" + email
				+ ", mobile=" + mobile + ", type=" + type + "]";
	}
	
	
	
	
	
	
	

}
