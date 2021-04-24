package com.example.biddingsystem.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.biddingsystem.constants.Constants;

@Entity(name=Constants.BIDDINGASSIGNED_TABLE_NAME)
@IdClass(BiddingAssignedIds.class)
public class BiddingAssigned {
	@Id
	@Column(nullable=false)
	private String userId;
	
	@Id
	@Column(nullable=false)
	private String productId;
	
	@Column(nullable=false)
	private Timestamp timeStamp;
	
	@Column(nullable=false)
	private boolean isNotificationSend ;

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

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isNotificationSend() {
		return isNotificationSend;
	}

	public void setNotificationSend(boolean isNotificationSend) {
		this.isNotificationSend = isNotificationSend;
	}
	
}
