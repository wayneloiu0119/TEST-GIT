package com.wayne.controller;

import java.util.Date;

public class userBean {
	
	private Object userName;
	private Object email;
	private Object pswd;
	private Object gender;
	private Object phone;
	private Object birthday;
	private Object nowTime;
	public Object getUserName() {
		return userName;
	}
	public void setUserName(Object object) {
		this.userName = object;
	}
	public Object getEmail() {
		return email;
	}
	public void setEmail(Object object) {
		this.email = object;
	}
	public Object getPswd() {
		return pswd;
	}
	public void setPswd(Object object) {
		this.pswd = object;
	}
	public Object getGender() {
		return gender;
	}
	public void setGender(Object object) {
		this.gender = object;
	}
	public Object getPhone() {
		return phone;
	}
	public void setPhone(Object object) {
		this.phone = object;
	}
	public Object getBirthday() {
		return birthday;
	}
	public void setBirthday(Object object) {
		this.birthday = object;
	}
	public Object getNowTime() {
		return nowTime;
	}
	public void setNowTime(Object object) {
		this.nowTime = object;
	}
	
	@Override
	public String toString() {
		return "userBean [userName=" + userName + ", email=" + email + ", pswd=" + pswd + ", gender=" + gender
				+ ", phone=" + phone + ", birthday=" + birthday + ", nowTime=" + nowTime + "]";
	}
	
	

}
