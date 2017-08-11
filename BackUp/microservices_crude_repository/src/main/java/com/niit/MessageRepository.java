package com.niit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>, MessageRepositoryCustom{

	public Message getByMessageID(Integer id);
}