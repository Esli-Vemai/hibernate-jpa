package com.jpa.hibernate.relationship;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.relationship.entity.Review;
import com.jpa.hibernate.relationship.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateRelationshipOne2manyApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateRelationshipOne2manyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//courseRepository.addHardcodedReviewsForCourse();
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great Hands-on Stuff."));
		reviews.add(new Review("5", "Hatsoff."));
		courseRepository.addReveiwsForCourse(10001L, reviews);
		
	}

}
