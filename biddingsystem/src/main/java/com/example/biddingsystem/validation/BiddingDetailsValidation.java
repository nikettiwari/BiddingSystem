package com.example.biddingsystem.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biddingsystem.exception.InvalidInputException;
import com.example.biddingsystem.exception.MyException;
import com.example.biddingsystem.pojo.BiddingDetails;
import com.example.biddingsystem.pojo.Product;
import com.example.biddingsystem.pojo.User;
import com.example.biddingsystem.pojo.Vendor;
import com.example.biddingsystem.repository.BiddingDetailsRepository;
import com.example.biddingsystem.repository.ProductRepository;
import com.example.biddingsystem.repository.UserRepository;
import com.example.biddingsystem.repository.VendorRepository;

@Service
public class BiddingDetailsValidation {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	VendorRepository vendorRepository;	
	
	@Autowired
	BiddingDetailsRepository borrowDetailsRepository;
	
	@Autowired
	BiddingDetailsRepository biddingDetailsRepository;
	
	public void checkUserAlreadyExistOrNot(String userId) throws MyException
	{
		if(userRepository.findById(userId).isPresent())
			throw new MyException("UserId already exist please give different userid");
	}
	public void checkVendorAlreadyExistOrNot(String vendorId) throws MyException
	{
		if(vendorRepository.findById(vendorId).isPresent())
			throw new MyException("VendorId already exist please give different userid");
	}
	
	public void checkVendorPresentOrNot(String vendorId) throws  InvalidInputException
	{
	if(!vendorRepository.findById(vendorId).isPresent())
		throw new InvalidInputException("VendorId is not registered please provide correct VendorId");
	}
	
	public void checkProductIdIAlreadyPresentOrNot(String productId) throws MyException {
		if(productRepository.findById(productId).isPresent())
			throw new MyException("ProductId already exist please give different ProductId");
	}
	public void checkProductIdIsPresentOrNot(String productId) throws InvalidInputException {
		if(!productRepository.findById(productId).isPresent())
			throw new InvalidInputException( "Product id  is not present . please provide correct productid");
	}

	public void checkUserIsRegisteredorNot(String userId) throws InvalidInputException {
		if(!userRepository.findById(userId).isPresent())
			throw new InvalidInputException("userid "+userId+" is not registered user so he/she can not bid ");
	}

	public void validateUser(User user) throws InvalidInputException {
		if(user.getUserId()==null)
			throw new InvalidInputException("userid is manadatory field");
		if(user.getPassword()==null || user.getPassword().length()<5)	
			throw new InvalidInputException("password is manadatory field and its length should be greater than 5");
		if(user.getUserName()==null)
			throw new InvalidInputException("username is manadatory field");
	}

	public void validateVendor(Vendor vendor) throws InvalidInputException {
		if(vendor.getVendorId()==null)
			throw new InvalidInputException("vendorid is manadatory field");
		if(vendor.getPassword()==null || vendor.getPassword().length()<5)	
			throw new InvalidInputException("password is manadatory field and its length should be greater than 5");
		if(vendor.getVendorName()==null)
			throw new InvalidInputException("vendorName is manadatory field");

	}
	public void validateProduct(Product product) throws InvalidInputException {
		if(product.getProductId()==null)
			throw new InvalidInputException("productId is manadatory field");
		if(product.getVendorId()==null)
			throw new InvalidInputException("vendorId is manadatory field");
		if(product.getProductName()==null)
			throw new InvalidInputException("Product name is manadatory field");
		if(product.getStartTimeForBid()==null)
			throw new InvalidInputException("bidding start time is manadatory field");
		if(product.getEndTimeForBid()==null)
			throw new InvalidInputException("bidding end time is manadatory field");
	
	}

	public void validateBiddingDetails(BiddingDetails biddingDetails) throws InvalidInputException {
		if(biddingDetails.getProductId()==null)
			throw new InvalidInputException("productId is manadatory field");
		if(biddingDetails.getUserId()==null)
			throw new InvalidInputException("User Id is manadatory field");
		if(biddingDetails.getBidPrice()==null)
			throw new InvalidInputException("bid Price is manadatory field");
		if(biddingDetails.getTimeStamp()==null)
			throw new InvalidInputException("timestamp  is manadatory field");
		
	}

	public void validateBidDetailsForProduct(BiddingDetails biddingDetails) throws InvalidInputException {
		Product product=productRepository.findById(biddingDetails.getProductId()).get();
		if(biddingDetails.getTimeStamp().compareTo(product.getStartTimeForBid())<0)
			throw new InvalidInputException(" Bidding time for given product is not started");
		if(biddingDetails.getTimeStamp().compareTo(product.getEndTimeForBid())>0)
			throw new InvalidInputException(" Bidding time for given product is ended ");
		if(biddingDetails.getBidPrice()<product.getBasePrice())
			throw new InvalidInputException(" Bidding Price for given product should be greater than base price");
		
	}
	public void checkBidAlreadySubmittedOrNot(String userId,String productId) throws InvalidInputException {
		if(biddingDetailsRepository.findByUserIdAndProductId(userId,productId).isPresent())
			throw new InvalidInputException("User already submitted bid for given productid");	
	}


}
