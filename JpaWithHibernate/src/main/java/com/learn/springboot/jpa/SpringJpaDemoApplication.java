package com.learn.springboot.jpa;

import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.springboot.jpa.entity.Person;
import com.learn.springboot.jpa.jdbc.PersonJbdcDao;
import com.learn.springboot.jpa.jpaRepo.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository jpaReposity;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person with id=10001: ->{}", jpaReposity.findById(10001));

		logger.info("All Users: ->{}", jpaReposity.findAll());

		logger.info("Deleting 10002 >>>>>>>>>>>>>>>>>");
		jpaReposity.deleteById(10002);

		logger.info("No of rows inserted: -> {}", jpaReposity.insert(new Person(10003,
				"This is from insert. But since I have provided the id", "It will behave as an update", new Date())));

		logger.info("Updated id 10003: ->{}",
				jpaReposity.update(new Person("This is from update statement but since I did not provide the id",
						"It will behave as insert and insert a new person", new Date())));

		

	}

}
