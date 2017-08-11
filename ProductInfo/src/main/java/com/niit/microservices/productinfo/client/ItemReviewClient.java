package com.niit.microservices.productinfo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

// In case of Eureka add the protocol 
@FeignClient(name = "http://ITEM-REVIEW", fallback = ItemReviewClient.ItemReviewServiceFallback.class)
//
// Without eureka: name is used to fetch properties from yml.
//@FeignClient(name = "ITEMINFO-SERVICE", fallback = ItemInfoClient.ItemInfoServiceFallback.class)
public interface ItemReviewClient extends ItemInfoService {

	@Component
	public class ItemReviewServiceFallback implements ItemReviewClient {
		@Override
		public String getItemReview(int id) {
			return "{\"id\":" + id + ",\"name\":\"A\",\"category\":\"book\",\"description\":\"desc\","
					+ "\"image\":\"abc.jpg\",\"price\":20.0}";
		}
	}
}