package com.niit.microservices.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.microservices.data.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>, MessageRepositoryCustom{

	public Message getByMessageID(Integer id);
}