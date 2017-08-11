package com.niit.microservices.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.niit.microservices.data.Message;

public class MessageRepositoryImpl implements MessageRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Message getByMessageID(Integer Id) {
		return this.entityManager.find(Message.class,Id);
	}
}