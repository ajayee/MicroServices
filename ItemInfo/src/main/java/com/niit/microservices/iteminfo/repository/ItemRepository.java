package com.niit.microservices.iteminfo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.microservices.iteminfo.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}