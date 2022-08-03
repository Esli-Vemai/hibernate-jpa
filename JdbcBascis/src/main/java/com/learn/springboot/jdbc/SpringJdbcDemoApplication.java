package com.learn.springboot.jdbc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.springboot.jdbc.entity.Person;
import com.learn.springboot.jdbc.repo.PersonJbdcDao;

@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJbdcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All Users: ->{}", dao.findAll());
		
		logger.info("Person with id=10001: ->{}", dao.findById(10001));
		
		logger.info("Person name James: -> {}", dao.findByName("James"));
		
		logger.info("No of rows deleted is: ->{}", dao.deleteById(10002, "James"));
		
		logger.info("No of rows inserted: -> {}", dao
				//.insertIntoPerson(new Person(11111, "Esli Joel", "Saranamai Village", Date.valueOf(LocalDate.now()))));
				.insertIntoPerson(new Person(11111, "Esli Joel", "Saranamai Village", new Date())));
		
		logger.info("Updated id 10003: ->{}", dao.updatePerson(new Person(10003, "Haaland", "ManCity", new Date())));

	}

}
