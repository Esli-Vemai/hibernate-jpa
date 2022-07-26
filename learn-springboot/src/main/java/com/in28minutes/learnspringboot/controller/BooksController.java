/**
 * 
 */
package com.in28minutes.learnspringboot.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.beans.Courses;

/**
 * @author esliv
 *
 */
@RestController
public class BooksController {

	@GetMapping("/courses")
	public List<Courses> getCourses() {
		return Arrays.asList(new Courses(1, "Learning Microservices", "In28Minutes"),
				new Courses(2, "Learn Spring Data JPA", "In28Minutes"));
	}
	
	@GetMapping("/courses/1")
	public Courses getACourse(){		
		return new Courses(1, "Learn SpringBoot", "in28Minutes");
	}

}
