package com.jpa.hibernate.relationship;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.relationship.entity.Employee;
import com.jpa.hibernate.relationship.entity.FullTimeEmployee;
import com.jpa.hibernate.relationship.entity.PartTimeEmployee;
import com.jpa.hibernate.relationship.entity.Review;
import com.jpa.hibernate.relationship.repository.CourseRepository;
import com.jpa.hibernate.relationship.repository.EmployeeRepository;
import com.jpa.hibernate.relationship.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateInheritanceHierarchiesApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository empRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInheritanceHierarchiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		empRepo.insertAnEmployee(new FullTimeEmployee("Jack", new BigDecimal(10000)));
		empRepo.insertAnEmployee(new PartTimeEmployee("Jill", new BigDecimal(50)));
		
		//logger.info("All employees -> {}", empRepo.retrieveAllEmployees());
		
		logger.info("All partime employees -> {}", empRepo.retreiveAllPartTimeEmployees());
		logger.info("All fulltime employees -> {}", empRepo.retreiveAllFullTimeEmployees());
		
	}

}
