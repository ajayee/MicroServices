package com.niit.microservices.productinfo.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// Benefits to keep the signature of the name and fall back same.
public interface ItemInfoService {

	@RequestMapping("/items/{Id}")
	public String getItemInfo(@PathVariable("Id") int id);

}