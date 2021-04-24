package com.example.biddingsystem.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.biddingsystem.exception.InvalidInputException;
import com.example.biddingsystem.exception.MyException;
import com.example.biddingsystem.pojo.Vendor;
import com.example.biddingsystem.repository.VendorRepository;
import com.example.biddingsystem.validation.BiddingDetailsValidation;

@RestController
public class VendorController {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	BiddingDetailsValidation biddingDetailsValidation;
	
	@PostMapping("/addVendor")
	@Transactional
	public  ResponseEntity<String> addVendor(@RequestBody Vendor vendor)
	{
		try
		{
		biddingDetailsValidation.validateVendor(vendor);
		biddingDetailsValidation.checkVendorAlreadyExistOrNot(vendor.getVendorId());
		vendorRepository.save(vendor);
		}
		catch(MyException myException)
		{
		  return ResponseEntity.status(HttpStatus.OK).body(myException.getErrorMessage());
		}
		catch(InvalidInputException invalidInputException)
		{
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidInputException.getErrorMessage());
		}
		 return ResponseEntity.status(HttpStatus.CREATED).body("Succesfully added Vendor");
	}
}
