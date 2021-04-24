package com.example.biddingsystem.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.biddingsystem.exception.InvalidInputException;
import com.example.biddingsystem.pojo.BiddingDetails;
import com.example.biddingsystem.repository.BiddingDetailsRepository;
import com.example.biddingsystem.validation.BiddingDetailsValidation;

@RestController
public class BiddingSystemController {
	
	@Autowired
	BiddingDetailsRepository biddingDetailsRepository;
	
	@Autowired
	BiddingDetailsValidation biddingDetailsValidation;
	
	@PostMapping("/addBidding")
	@Transactional
	public ResponseEntity<String> addBidding(@RequestBody BiddingDetails biddingDetails) 
	{	
		try
		{
			biddingDetailsValidation.validateBiddingDetails(biddingDetails);
			String userId=biddingDetails.getUserId();
			String productId=biddingDetails.getProductId();
			biddingDetailsValidation.checkBidAlreadySubmittedOrNot(userId,productId);
			biddingDetailsValidation.checkUserIsRegisteredorNot(userId);
			biddingDetailsValidation.checkProductIdIsPresentOrNot(productId);
			biddingDetailsValidation.validateBidDetailsForProduct(biddingDetails);
			biddingDetailsRepository.save(biddingDetails);
		}
		catch(InvalidInputException invalidInputException)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidInputException.getErrorMessage());
		}
			return ResponseEntity.status(HttpStatus.OK).body("SuccessFully bid for products");

	}
}
