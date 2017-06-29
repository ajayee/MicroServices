package com.niit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MessageRepositoryImpl implements MessageRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Message getByMessageID(Integer Id) {
		return this.entityManager.find(Message.class,Id);
	}
}