package cn.itcast.bookstore.domain;

import java.util.Date;

public class User {

	private String uid;//����
	private String username;//�û���
	private String password;
	private String email;
	
	
	private String gender;
	private String cellphone;
	private String preferences;
	
	private Date birth; 
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
