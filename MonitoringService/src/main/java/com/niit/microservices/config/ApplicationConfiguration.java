package com.niit.microservices.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.microservices.data.HelloWorld;
import com.niit.microservices.service.MessageRepositoryCustom;
import com.niit.microservices.service.MessageRepositoryImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.niit.microservices.web"})
@EnableJpaRepositories(basePackages = {
        "com.niit"
})
@EnableTransactionManagement
public class ApplicationConfiguration {

	@Bean
	public HelloWorld getHelloWorld() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("Hello World");
		return helloWorld;
	}

	@Bean(name="myCustomRepository")
	public MessageRepositoryCustom getMessageRepository() {
		MessageRepositoryCustom messageRepository = new MessageRepositoryImpl();
		return messageRepository;
	}
	
	@Bean
	public DataSource dataSource() throws SQLException {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("password");
		ds.setUrl("jdbc:mysql://localhost:3306/MicroServices");
        return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		try {
                em.setDataSource(dataSource());
                em.setPackagesToScan(new String[] { "com.niit" });

                JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
                em.setJpaVendorAdapter(vendorAdapter);
                em.setJpaProperties(additionalProperties());
		
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}
		
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

}