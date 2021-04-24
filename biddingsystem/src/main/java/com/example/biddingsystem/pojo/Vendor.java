package com.example.biddingsystem.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.biddingsystem.constants.Constants;

@Entity(name=Constants.VENDOR_TABLE_NAME)
public class Vendor {
	
	@Id
	@Column
	private String vendorId;
	@Column
	private String vendorName;
	@Column
	private String phoneNumber;
	@Column(nullable=false)
	private String password;
	
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
