package com.example.biddingsystem.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.biddingsystem.constants.Constants;


@Entity(name=Constants.BIDDINGDETAILS_TABLE_NAME)
@IdClass(BiddingDetailsIds.class)
public class BiddingDetails {

	@Id
	@Column(nullable=false)
	private String userId;
	
	@Id
	@Column(nullable=false)
	private String productId;

	@Column(nullable=false)
	private Double bidPrice;
	
	@Column(nullable=false)
	private Timestamp timeStamp;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	
}
