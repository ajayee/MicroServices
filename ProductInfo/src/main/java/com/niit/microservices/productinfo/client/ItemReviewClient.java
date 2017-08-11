package com.niit.microservices.productinfo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.niit.microservices.productinfo.client.ItemReviewService;


// In case of Eureka add the protocol 
@FeignClient(name = "http://ITEM-REVIEW", fallback = ItemReviewClient.ItemReviewServiceFallback.class)
//
// Without eureka: name is used to fetch properties from yml.
//@FeignClient(name = "ITEMINFO-SERVICE", fallback = ItemReviewClient.ItemReviewServiceFallback.class)
public interface ItemReviewClient extends ItemReviewService {

	@Component
	public class ItemReviewServiceFallback implements ItemReviewClient {
		@Override
		public String getItemReview(int id) {
			return "{\"id\":" + id + ",\"name\":\"A\",\"category\":\"book\",\"description\":\"desc\","
					+ "\"image\":\"abc.jpg\",\"price\":20.0}";
		}
	}
}