package com.jpa.hibernate.relationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jpa.hibernate.relationship.entity.Course;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	// We be define custom methods by just declaring the method name using keywors
	// like "find", "delete", "count"
	
	List<Course> findByName(String name);
	//Course findByGivenId(Long id);
	
	
	//Course deleteByName(String name);
	List<Course> deleteByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	
	List<Course> countByName(String name);
	//int countByName(String name);
	
	@Query("select c from Course c where name like '%50 Steps'")
	List<Course> courseWith50StepsInTheName(); 
	
	@Query(value = "select * from Course where name like '%50 Steps'", nativeQuery = true)
	List<Course> courseWith50StepsInTheNameUsingNativeQuery(); 
	
	@Query(name = "query_get_all_courses")
	// This query name is defined in the Course entity
	List<Course> courseWith50StepsInTheNameUsingNamedQuery(); 

}
