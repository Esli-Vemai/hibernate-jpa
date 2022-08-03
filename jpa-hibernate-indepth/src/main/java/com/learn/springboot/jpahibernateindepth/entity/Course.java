/**
 * 
 */
package com.learn.springboot.jpahibernateindepth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author esliv
 *
 */
@Entity
//NamedQuery(name="", query="")
public class Course {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
