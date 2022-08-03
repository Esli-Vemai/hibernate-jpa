package com.jpa.hibernate.relationship.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.relationship.JpaHibernateJpqlApplication;
import com.jpa.hibernate.relationship.entity.Course;
import com.jpa.hibernate.relationship.entity.Student;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateJpqlApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		logger.info("Select  c  From Course c -> {}", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Select  c  From Course c -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Select  c  From Course c where name like '%100 Steps'-> {}", resultList);
		// [Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
	}

	
	
	
	//================================================
	
	
	@Test
	public void jpql_courses_without_any_student() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty",
				Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Courses with atleast 2 stuents ->{}", resultList);
	}
	
	
	@Test
	public void jpql_courses_with_atleast_2_Students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >=2",
				Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Courses with atleast 2 stuents ->{}", resultList);
	}

	@Test
	public void jpql_courses_order_by_student_size() {
		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc",
				Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Courses ordered by student size ->{}", resultList);
	}
	
	@Test
	public void jpql_student_with_passport_no_in_a_certain_pattern() {
		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%1234%'",
				Student.class);

		List<Student> resultList = query.getResultList();

		logger.info("Student with passport number containing \"1234\" ->{}", resultList);
	}
	
	/**
	 * We also have JPQL queries for 
	 * > like
	 * > between
	 * > is null
	 * > upper, lower, trim, length
	 */
	
	
	
	
	
	
	/**
	 * Types of Join
	 * 1. Join -> select c,s from Course c JOIN c.students s
	 * 2. Left Join -> select c,s from Course c LEFT JOIN c.students s
	 * 3. Cross Join -> select c,s from Course c, Student s
	 * 		- here if we have 3 course and 4 students, it will return 3*4 = 12 rows
	 */
	
	
	@Test
	public void join() {
		// as the result will contain both Course and Student, we cannot use typed query any longer
		Query join = em.createQuery("select c,s from Course c JOIN c.students s");
		
		// the query returns an Array of arrays of objects that contains Course and Student objects, that is -> List<Object[]>
		List<Object[]> results = join.getResultList();
		logger.info("Result size::::::  {}", results.size());
		results.forEach(array -> logger.info("Course: {}, Student: {}", array[0], array[1]));
		
		//results.forEach(array ->  System.out.println("SDSDSDSDSDS" + array.toString()));
		
	}
	
	
	@Test
	public void left_join() {
		// as the result will contain both Course and Student, we cannot use typed query any longer
		Query join = em.createQuery("select c,s from Course c LEFT JOIN c.students s");
		
		// the query returns an Array of arrays of objects that contains Course and Student objects, that is -> List<Object[]>
		List<Object[]> results = join.getResultList();
		logger.info("Result size::::::  {}", results.size());
		results.forEach(array -> logger.info("Course: {}, Student: {}", array[0], array[1]));
		
	}
	
	
	@Test
	public void cross_join() {
		// as the result will contain both Course and Student, we cannot use typed query any longer
		Query join = em.createQuery("select c,s from Course c, Student s");
		
		// the query returns an Array of arrays of objects that contains Course and Student objects, that is -> List<Object[]>
		List<Object[]> results = join.getResultList();
		logger.info("Result size::::::  {}", results.size());
		results.forEach(array -> logger.info("Course: {}, Student: {}", array[0], array[1]));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
