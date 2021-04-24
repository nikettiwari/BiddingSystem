package com.example.biddingsystem.scheduler;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biddingsystem.pojo.BiddingAssigned;
import com.example.biddingsystem.pojo.BiddingDetails;
import com.example.biddingsystem.pojo.Product;
import com.example.biddingsystem.repository.BiddingAssignedRepository;
import com.example.biddingsystem.repository.BiddingDetailsRepository;
import com.example.biddingsystem.repository.ProductRepository;

@Service
public class SendNotificationToUser implements Runnable {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BiddingDetailsRepository biddingDetailsRepository;
	
	@Autowired
	BiddingAssignedRepository biddingAssignedRepository;
	
	@Override
	@Transactional
	public void run() {
		Timestamp today= new Timestamp(System.currentTimeMillis());
		List<Product> productList=productRepository.findProductNotAssigned(today);
		for(int i=0;i<productList.size();i++)
		{
			Product product=productList.get(i);
			List<BiddingDetails> biddingDetails=biddingDetailsRepository.findMaxBidPrice(product.getProductId());
			System.out.println("size is "+biddingDetails.size());
			if(biddingDetails.size()>0)
			{
			System.out.println(" bid for product id "+product.getProductId()+" is won by "+biddingDetails.get(0).getUserId());
			//send notification
			product.setProductAssigned(true);
			productRepository.save(product);
			BiddingAssigned biddingAssigned= new BiddingAssigned();
			biddingAssigned.setUserId(biddingDetails.get(0).getUserId());
			biddingAssigned.setTimeStamp(today);
			biddingAssigned.setProductId(product.getProductId());
			biddingAssigned.setNotificationSend(true);
			biddingAssignedRepository.save(biddingAssigned);
			}
		}	
	}
}
