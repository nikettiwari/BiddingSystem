package com.example.biddingsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.biddingsystem.exception.InvalidInputException;
import com.example.biddingsystem.exception.MyException;
import com.example.biddingsystem.pojo.Product;
import com.example.biddingsystem.repository.ProductRepository;
import com.example.biddingsystem.validation.BiddingDetailsValidation;

@RestController
public class ProductController {
	@Autowired
	BiddingDetailsValidation biddingDetailsValidation;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/addProduct")
	@Transactional
	public  ResponseEntity<String> addProduct(@RequestBody Product product) 
	{
		try
		{
		biddingDetailsValidation.validateProduct(product);
		biddingDetailsValidation.checkProductIdIAlreadyPresentOrNot(product.getProductId());
		biddingDetailsValidation.checkVendorPresentOrNot(product.getVendorId());
		productRepository.save(product);
		}
		catch(MyException myException)
		{
			return ResponseEntity.status(HttpStatus.OK).body(myException.getErrorMessage());
		}
		catch(InvalidInputException invalidInputException)
		{
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidInputException.getErrorMessage());
		}
		catch(Exception exception)
		{
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Succesfully added Product");
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getALlProduct()
	{
		return productRepository.findAll();
	} 
	
}
