package com.example.biddingsystem.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.biddingsystem.constants.Constants;

@Entity(name=Constants.USER_TABLE_NAME)
public class User {
	
	@Id
	@Column
	private String userId;
	@Column(nullable=false)
	private String userName;
	@Column
	private String phoneNumber;
	@Column(nullable=false)
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userID) {
		this.userId = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
