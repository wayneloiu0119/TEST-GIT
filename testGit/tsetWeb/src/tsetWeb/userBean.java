package tsetWeb;

import java.util.Date;

public class userBean {
	
	private String userId;
	private String userName;
	private String email;
	private String pswd;
	private String gender;
	private int phone;
	private Date birthday;
	private String address;
	private Date insertTime;
	private String listId;
	private String userLevel;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	
	
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	@Override
	public String toString() {
		return "userBean [userId=" + userId + ", userName=" + userName + ", email=" + email + ", pswd=" + pswd
				+ ", gender=" + gender + ", phone=" + phone + ", birthday=" + birthday + ", address=" + address
				+ ", insertTime=" + insertTime + ", listId=" + listId + ", userLevel=" + userLevel + "]";
	}
	
	
	
	
	
	


}
