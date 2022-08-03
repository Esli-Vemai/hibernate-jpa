package com.jpa.hibernate.relationship.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.relationship.JpaHibernateCriteriaQueryApplication;
import com.jpa.hibernate.relationship.entity.Course;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateCriteriaQueryApplication.class)
public class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void all_courses() {
		// TO establish "Select c From Course c" in Criteria query we define the below 5 steps.

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
			//-> we don't have any predicates so this line is blank
		
		// 4. Add Predicates etc to the Criteria Query
			//-> we don't have any predicates so this line is blank
		
		
		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
		// [Course[JPA in 50 Steps], Course[Spring in 50 Steps], Course[Spring
		// Boot in 100 Steps]]
		
		
	}
	
	
	@Test
	public void all_courses_having_100Steps() {
		// "Select c From Course c where name like '%100 Steps' "

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");

		// 4. Add Predicates etc to the Criteria Query
		cq.where(like100Steps);

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		logger.info("Typed Query -> {}", resultList);
		// [Course[Spring Boot in 100 Steps]]
	}
	
	
	@Test
	public void all_courses_without_students() {
		// "Select c From Course c where c.students is empty"
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> courseRoot = cq.from(Course.class);

		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));

		cq.where(studentsIsEmpty);

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
		// [Course[Spring in 50 Steps]]
	}

	@Test
	public void join() {
		// "Select c From Course c join c.students s"	
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);

		Join<Object, Object> join = courseRoot.join("students");

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
		// [Course[JPA in 50 Steps], Course[JPA in 50 Steps], Course[JPA in 50
		// Steps], Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void left_join() {
		// "Select c From Course c left join c.students s"

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		Root<Course> courseRoot = cq.from(Course.class);

		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
		// [Course[JPA in 50 Steps], Course[JPA in 50 Steps], Course[JPA in 50
		// Steps], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
	}
	
}
