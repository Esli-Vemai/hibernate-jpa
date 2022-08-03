package com.learn.springboot.jpahibernateindepth.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.springboot.jpahibernateindepth.entity.Course;

public class CourseJpaRepoUsingJQL {
	
	@Autowired
	EntityManager em;
	
	public List jpqlBasic() {
		Query course = em.createQuery("select c from Course c");
		return course.getResultList();
	}
	
	public List<Course> jpqlWithType() {
		 TypedQuery<Course> course = em.createQuery("select c from Course c", Course.class);
		return course.getResultList();
	}
	
	public List<Course> jpqlWhere() {
		TypedQuery<Course> where = em.createQuery("select c from Course c where name like '%50 Steps'", Course.class);
		List<Course> whereList = where.getResultList();
		return whereList;
		
	}

}
