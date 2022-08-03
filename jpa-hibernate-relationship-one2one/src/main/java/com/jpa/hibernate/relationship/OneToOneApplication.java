package com.jpa.hibernate.relationship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.relationship.entity.Course;
import com.jpa.hibernate.relationship.repository.CourseRepository;
import com.jpa.hibernate.relationship.repository.StudentRepository;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private StudentRepository studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		studentRepo.saveStudentWithPassport();
	}	
}
