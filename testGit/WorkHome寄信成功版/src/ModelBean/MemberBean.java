package ModelBean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemberBean  {
	
	private static final long serialVersionUID = 1L;
	private String memberId;
	private String password;
	private String name;
	private java.util.Date birthday;
	private String email;
	private String phone;
	
	public MemberBean() {
		
	}

	
	public MemberBean(String memberId, String password, String name, Date birthday, String email, String phone) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static java.util.Date convertDate(String temp){
		java.util.Date result = new java.util.Date();
		try {
			result=sdf.parse(temp);
		} catch (ParseException e) {
			result = null ; 
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", password=" + password + ", name=" + name + ", birthday="
				+ birthday + ", email=" + email + ", phone=" + phone + "]";
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
