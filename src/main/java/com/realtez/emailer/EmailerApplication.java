package com.realtez.emailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.realtez.emailer.jpa.AgentRepository;

@SpringBootApplication
public class EmailerApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AgentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmailerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Agent Id 10001 -> {}", repository.findById(10001L));
 
		repository.deleteById(10002L);

		logger.info("All agents -> {}", repository.findAll());
	}
}