package com.example.biddingsystem.constants;

public final class Constants {
	
	  private Constants() {
			throw new IllegalStateException("Cannot Instantiate Constants");
		}

    public static final String VENDOR_TABLE_NAME = "Vendor";
    public static final String USER_TABLE_NAME = "User";
    public static final String PRODUCT_TABLE_NAME = "Product";
    public static final String BIDDINGDETAILS_TABLE_NAME = "BiddingDetails";
    public static final String BIDDINGASSIGNED_TABLE_NAME = "BiddingAssigned";

}
