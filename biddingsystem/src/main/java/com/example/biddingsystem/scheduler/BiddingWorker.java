package com.example.biddingsystem.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class BiddingWorker {

	@Autowired 
	SendNotificationToUser sendNotificationToUser;
	
	 @Scheduled(fixedRate = 20000)
	 public void startWorker()
	 {
		 System.out.println("started");
		 Thread t= new Thread(sendNotificationToUser);
		 t.start();
	 }

}
