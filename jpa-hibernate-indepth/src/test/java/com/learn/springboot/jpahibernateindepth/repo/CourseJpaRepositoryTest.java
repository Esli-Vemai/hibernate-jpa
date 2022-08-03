package com.learn.springboot.jpahibernateindepth.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.springboot.jpahibernateindepth.JpaHibernateIndepthApplication;
import com.learn.springboot.jpahibernateindepth.entity.Course;

//@RunWith(SpringRunner.class) -> no longer need in JUnit 5
@SpringBootTest(classes = JpaHibernateIndepthApplication.class)
class CourseJpaRepositoryTest {

	Logger logger = LoggerFactory.getLogger(CourseJpaRepositoryTest.class);

	@Autowired
	CourseJpaRepository courseJpa;

	@Test
	void testFindById() {
		logger.info("testFindById() test method started.");
		Course course = courseJpa.findById(2222L);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	// Use this annotation when your test changes the actual data of the app.
	// It restores the state of the object/context to the original state after test
	@DirtiesContext
	void testDeleteById() {
		logger.info("testDeleteById()");
		courseJpa.deleteById(2222L);
		assertNull(courseJpa.findById(2222L));
	}

	@Test
	@DirtiesContext
	void testSave() {
		Course updatedCourse = courseJpa.findById(2222L);
		// Jpa with Hibernate - Updated
		updatedCourse.setName("JPA in 50 Steps - Updated");
		courseJpa.save(updatedCourse);
		assertEquals("JPA in 50 Steps - Updated", courseJpa.findById(2222L).getName());

	}

}
