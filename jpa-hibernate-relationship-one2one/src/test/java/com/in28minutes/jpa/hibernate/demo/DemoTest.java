package com.in28minutes.jpa.hibernate.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.relationship.OneToOneApplication;
import com.jpa.hibernate.relationship.entity.Passport;
import com.jpa.hibernate.relationship.entity.Student;

@SpringBootTest(classes = OneToOneApplication.class)
public class DemoTest {
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	public void fetchStudentFromPassportDetails() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("Passport: ->{}", passport );
		//em.persist(passport);
		Student student = passport.getStudent();
		logger.info("Student with passportId 40001 is: ->{}", student);
		assertEquals("Ranga", student.getName());
	}

}
