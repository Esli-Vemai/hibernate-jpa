package com.learn.springboot.jpa.jpaRepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springboot.jpa.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	// persistance context stores all the operations performed in a session
	@PersistenceContext
	// entity manager is the interface to persistance context that manages the
	// entities
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);

	}

	public Person findByName(String name) {
		return entityManager.find(Person.class, name);
	}

	public List<Person> findAll() {
		TypedQuery<Person> findAll = entityManager.createNamedQuery(
				"find all persons or this could be any comment if it matches with the one in PersonJpaRepository class",
				Person.class);
		return findAll.getResultList();
	}
	
	public Person update(Person person) {
		// the merge() method will either insert or update the record in the table based one whether the 
		// person.id is already in the table or not. So both update and insert are the same in JPA
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		// the merge() method will either insert or update the record in the table based one whether the 
		// person.id is already in the table or not. So both update and insert are the same in JPA
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		//First we need to find the person we want to delete
		entityManager.remove(entityManager.find(Person.class, id));
	}

}
