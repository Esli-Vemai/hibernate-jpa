package com.jpa.hibernate.relationship.repository;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.relationship.JpaHibernateRelationshipOne2manyApplication;
import com.jpa.hibernate.relationship.entity.Course;
import com.jpa.hibernate.relationship.entity.Review;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateRelationshipOne2manyApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {

		// get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	@Transactional
	public void retreiveReviewsForCourse() {
		Course course = repository.findById(10001L);
		//here fetching is Lazy coz Course to Review is OneToMany relationship
		logger.info("review for courseId 10001: -> {}", course.getReviews());
	}
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		//here fetching is Eager coz Review to Course is ManyToOne relationship
		logger.info("Course for reviewId 50001: ->{}", review.getClass());
		
	}

}
