package com.jpa.hibernate.relationship.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.jpa.hibernate.relationship.entity.Course;

@SpringBootTest
class CourseSpingDataJpaRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataJpaRepository jpaRepo;

	@Test
	void testFindById() {
		Optional<Course> course = jpaRepo.findById(10001L);
		assertTrue(course.isPresent());
		logger.info("Course with Id 10001 is : {}", course.get());
	}
	
	
	@Test
	void playAroundWithSpringDataJPA() {
		Course course = new Course("Spring Data JPA");
		jpaRepo.save(course);
		
		course.setName("Save method can be used for both saving new entity and updating existing entity");
		jpaRepo.save(course);
		
		logger.info("Count of all entities available: {}", jpaRepo.count());
		logger.info("Find all instances: {}", jpaRepo.findAll());
		
	}
	
	@Test
	void sort() {		
		Sort sort1 = Sort.by(Direction.ASC, "name");
		logger.info("Sorted Courses -> {} ", jpaRepo.findAll(sort1));
	}
	
	@Test
	void pagination() {
		//PageRequest pageRq = PageRequest.of(0, 3);
		
		PageRequest pageRq = PageRequest.of(0, 3).withSort(Direction.ASC, "name");
		Page<Course> firstPage = jpaRepo.findAll(pageRq);
		logger.info("First page content: {}", firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		logger.info("Second page content: {}", jpaRepo.findAll(secondPageable).getContent());
	}
	
	
	/*
	 * @Test void testCustomQueriesDefinedByMe() {
	 * logger.info("Custom findByName:: {}", jpaRepo.findByName("JPA in 50 Steps"));
	 * 
	 * logger.info("Custom countByName:: {}",
	 * jpaRepo.findByName("JPA in 50 Steps"));
	 * 
	 * logger.info("Custom findById:: {}", jpaRepo.findByGivenId(10001L));
	 * 
	 * logger.info("Custom deleteByName:: {}",
	 * jpaRepo.deleteByName("JPA in 50 Steps"));
	 * 
	 * logger.info("Custom courseWith50StepsInTheName:: {}",
	 * jpaRepo.courseWith50StepsInTheName());
	 * 
	 * //logger.info("Custom deleteByName:: {}",
	 * jpaRepo.deleteByName("JPA in 50 Steps"));
	 * 
	 * //logger.info("Custom deleteByName:: {}",
	 * jpaRepo.deleteByName("JPA in 50 Steps")); }
	 */

}
