package tsetWeb;

import java.util.Date;

public class userBean {
	
	private String email;
	private String pswd;
	private String gender;
	private int phone;
	private Date birthday;
	
	
	
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	@Override
	public String toString() {
		return "userBean [email=" + email + ", pswd=" + pswd + ", gender=" + gender + ", phone=" + phone + ", birthday="
				+ birthday + ", userName=" + userName + "]";
	}
	
	

}
