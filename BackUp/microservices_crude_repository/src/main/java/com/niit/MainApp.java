package com.niit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {

		/*
		 * AbstractApplicationContext context = new
		 * ClassPathXmlApplicationContext("spring.xml"); HelloWorld obj =
		 * (HelloWorld) context.getBean("helloWorld"); obj.getMessage();
		 * context.close();
		 */
		ApplicationContext appContext = new AnnotationConfigApplicationContext("com.niit");
		HelloWorld obj = (HelloWorld) appContext.getBean(HelloWorld.class);
		obj.getMessage();

		MessageRepositoryCustom messageRepository = (MessageRepositoryCustom)appContext.getBean("myCustomRepository");
		System.out.println("Hello " + messageRepository.getByMessageID(1).getMessage());
		
		((ConfigurableApplicationContext)appContext).close();
	}
}