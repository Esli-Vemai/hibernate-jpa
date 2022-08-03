package com.jpa.hibernate.relationship;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.relationship.entity.Course;
import com.jpa.hibernate.relationship.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateJpqlApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateJpqlApplication.class, args);
	}

	
	/**
	 * In JPQL queries we do not worry about what the table is. We only worry about
	 * entities and the relationships between them
	 * 
	 * 
	 */
	@Override
	public void run(String... args) throws Exception {
		//List<Course> course = courseRepo.retrieveCourseWithoutStudent();
		//course.forEach(c -> logger.info("Course without student -> {}",  c.toString()));
		
	}

}
