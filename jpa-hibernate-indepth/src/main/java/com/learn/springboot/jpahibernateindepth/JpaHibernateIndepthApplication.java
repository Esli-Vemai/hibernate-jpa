package com.learn.springboot.jpahibernateindepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.springboot.jpahibernateindepth.entity.Course;
import com.learn.springboot.jpahibernateindepth.repo.CourseJpaRepository;

@SpringBootApplication
public class JpaHibernateIndepthApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseJpaRepository jpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateIndepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = jpaRepo.findById(1111L);
		logger.info("Course for id: 1111 -> {}", jpaRepo.findById(2222L));		
		//jpaRepo.deleteById(2222);		
		jpaRepo.save(new Course("Microservices in 50 Steps"));
		
	}

}
