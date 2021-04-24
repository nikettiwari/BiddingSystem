package com.example.biddingsystem.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.biddingsystem.constants.Constants;

@Entity(name=Constants.PRODUCT_TABLE_NAME)
public class Product {
	@Id
	@Column
	private String productId;
	
	@Column
	private String productName;
	
	@Column(nullable=false)
	private Double basePrice;
	
	@Column
	private String productDetails;
	
	@Column(nullable=false)
	private Timestamp startTimeForBid;
	
	@Column(nullable=false)
	private Timestamp endTimeForBid;
	
	@Column(nullable=false)
	private String vendorId;
	
	@Column
	private boolean isProductAssigned;
	


	public boolean isProductAssigned() {
		return isProductAssigned;
	}

	public void setProductAssigned(boolean isProductAssigned) {
		this.isProductAssigned = isProductAssigned;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public Timestamp getStartTimeForBid() {
		return startTimeForBid;
	}

	public void setStartTimeForBid(Timestamp startTimeForBid) {
		this.startTimeForBid = startTimeForBid;
	}

	public Timestamp getEndTimeForBid() {
		return endTimeForBid;
	}

	public void setEndTimeForBid(Timestamp endTimeForBid) {
		this.endTimeForBid = endTimeForBid;
	}

}
