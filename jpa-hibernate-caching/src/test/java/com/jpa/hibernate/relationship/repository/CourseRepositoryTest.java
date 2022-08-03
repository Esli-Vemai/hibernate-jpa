package com.jpa.hibernate.relationship.repository;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.relationship.JpaHibernateCachingApplication;
import com.jpa.hibernate.relationship.entity.Course;
import com.jpa.hibernate.relationship.entity.Review;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateCachingApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void findById_firstLevelCacheDemo() {
		
		Course course = repository.findById(10001L);
		logger.info("First Course Retrieved {}", course);

		Course course1 = repository.findById(10001L);
		logger.info("First Course Retrieved again {}", course1);

		assertEquals("JPA in 50 Steps", course.getName());
		
		assertEquals("JPA in 50 Steps", course1.getName());
	}

}
