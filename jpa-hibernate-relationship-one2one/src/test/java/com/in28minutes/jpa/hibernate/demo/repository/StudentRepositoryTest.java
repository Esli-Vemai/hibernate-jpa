package com.in28minutes.jpa.hibernate.demo.repository;


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
import com.jpa.hibernate.relationship.repository.StudentRepository;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OneToOneApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void findStudentAlongwithPassport() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student with id 20001L fetched ->{}", student);
		logger.info("student passport ->{}", student.getPassport());
		assertEquals(40001L, student.getPassport().getId());
		
	}
	
	@Test
	@Transactional
	public void fetchStudentFromPassportDetails() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("Passport: ->{}", passport );
		Student student = passport.getStudent();
		logger.info("Student with passportId 40001 is: ->{}", student);
		assertEquals("Ranga", student.getName());
	}

	
}
