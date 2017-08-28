package com.niit.microservices.productinfo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

// In case of Eureka add the protocol 
@FeignClient(name = "http://ITEMINFO", fallback = ItemInfoClient.ItemInfoServiceFallback.class)
//
// Without eureka: name is used to fetch properties from yml.
//@FeignClient(name = "ITEMINFO-SERVICE", fallback = ItemInfoClient.ItemInfoServiceFallback.class)
public interface ItemInfoClient extends ItemInfoService {

	@Component
	public class ItemInfoServiceFallback implements ItemInfoClient {
		@Override
		public String getItemInfo(int id) {
			return "{\"id\":" + id + ",\"name\":\"A\",\"category\":\"book\",\"description\":\"desc\","
					+ "\"image\":\"abc.jpg\",\"price\":20.0}";
		}
		
		@Override
		public String getItems() {
			return "{\"id\":,\"name\":\"A\",\"category\":\"book\",\"description\":\"desc\","
					+ "\"image\":\"abc.jpg\",\"price\":20.0}";
		}
	}
}