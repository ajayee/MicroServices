package com.niit.microservices.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ItemService {

	@HystrixCommand(fallbackMethod = "getCachedItem")
	public String getItem(Integer Id) throws Exception{
		
		Thread.sleep(60*10000);
		throw new Exception ("Timeout after 1 minute");
	}
	
	public String getCachedItem(Integer Id) {
		return new String("Cahced Item");
	}	
}
