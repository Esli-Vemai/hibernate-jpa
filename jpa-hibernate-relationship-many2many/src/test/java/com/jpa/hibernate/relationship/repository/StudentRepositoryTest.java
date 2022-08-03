package com.jpa.hibernate.relationship.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.relationship.JpaHibernateRelationshipMany2manyApplication;
import com.jpa.hibernate.relationship.entity.Course;
import com.jpa.hibernate.relationship.entity.Passport;
import com.jpa.hibernate.relationship.entity.Student;

@SpringBootTest(classes = JpaHibernateRelationshipMany2manyApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	// Session & Session Factory

	// EntityManager & Persistence Context
	// Transaction

	@Test
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext();
	}

	@Test

	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}

	@Test

	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student:: -> {}", student);
		logger.info("courses:: -> {}", student.getCourses());
	}

	@Test
	@Transactional
	public void retrieveCourseAndStudents() {
		Course course = em.find(Course.class, 10001L);
		logger.info("course:: -> {}", course);
		logger.info("student:: -> {}", course.getStudents());

	}
	
}
