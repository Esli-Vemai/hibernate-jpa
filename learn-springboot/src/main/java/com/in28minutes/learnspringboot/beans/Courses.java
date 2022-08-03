/**
 * 
 */
package com.in28minutes.learnspringboot.beans;

/**
 * @author esliv
 *
 */
public class Courses {
	private int id;
	private String name;
	private String author;
	
	public Courses(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
