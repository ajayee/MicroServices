package com.niit.microservices.service;

import com.niit.microservices.data.Message;

public interface MessageRepositoryCustom {

	public Message getByMessageID(Integer id);
}
