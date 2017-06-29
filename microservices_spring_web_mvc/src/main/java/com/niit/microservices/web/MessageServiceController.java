package com.niit.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.microservices.data.Message;
import com.niit.microservices.service.MessageRepositoryCustom;

@RestController
public class MessageServiceController {
	
	@Autowired
	private MessageRepositoryCustom messageRepository;	
	
	//-------------------Retrieve Message --------------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, value = "message/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") int id) {	
    	System.out.println("Request came here >> " + id);
        
    	Message message = messageRepository.getByMessageID(id);
        System.out.println("Message received: " + message.getMessage());
        
        if(message.getMessage().trim().length() <= 0){
            return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }
}