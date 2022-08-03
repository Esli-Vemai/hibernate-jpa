/**
 * 
 */
package com.learn.springboot.jpahibernateindepth.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springboot.jpahibernateindepth.entity.Course;

/**
 * @author esliv
 *
 */
@Repository
@Transactional
public class CourseJpaRepository {
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {		
		return em.find(Course.class, id);
		
	}
	
	public void deleteById(Long id) {
		em.remove(findById(id));
	}
	
	public void save(Course course) {
		if(course.getId()== null) {
			System.out.println("Inside save() - persist()");
			em.persist(course);
		} else {
			System.out.println("Inside save() - merge()");
			em.merge(course);
		}
	}

}
