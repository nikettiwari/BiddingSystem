package com.example.bookexchange;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Optional;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.anyObject;

import com.example.biddingsystem.exception.InvalidInputException;
import com.example.biddingsystem.pojo.BiddingDetails;
import com.example.biddingsystem.pojo.Product;
import com.example.biddingsystem.pojo.User;
import com.example.biddingsystem.repository.ProductRepository;
import com.example.biddingsystem.repository.UserRepository;
import com.example.biddingsystem.validation.BiddingDetailsValidation;




@RunWith(MockitoJUnitRunner.class)
public class BookExchangeValidationTest {
	
	@InjectMocks
	@Autowired
	BiddingDetailsValidation biddingDetailsValidation;
	
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	ProductRepository productRepository;
	
	Optional<User> userOptionalEmpty;
	Optional<Product> prodcutOptionalEmpty;
	
	BiddingDetails biddingDetails;
	
	
	User user;
	
	Product product;



	@Before
	public void setup()  {
		biddingDetails= new BiddingDetails();
		biddingDetails.setTimeStamp( new Timestamp(System.currentTimeMillis()));
		Product product= new Product();
		product.setProductId("test");
		product.setStartTimeForBid(new Timestamp(System.currentTimeMillis()+1));
		 userOptionalEmpty=Optional.empty();
		 prodcutOptionalEmpty=Optional.of(product);
		 when(productRepository.findById(anyObject())).thenReturn(prodcutOptionalEmpty);
		 
		 when(userRepository.findById(anyObject())).thenReturn(userOptionalEmpty);
	
	}
	
	
	
	@Test(expected=InvalidInputException.class)
	public void testvalidateBiddingDetails()throws Exception
	{
		biddingDetailsValidation.validateBiddingDetails(biddingDetails);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testValidateBidDetailsForProduct()throws Exception
	{
		biddingDetailsValidation.validateBidDetailsForProduct(biddingDetails);
	}
	
}
