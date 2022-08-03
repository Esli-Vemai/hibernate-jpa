package com.jpa.hibernate.relationship.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.relationship.entity.Employee;
import com.jpa.hibernate.relationship.entity.FullTimeEmployee;
import com.jpa.hibernate.relationship.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	public void insertAnEmployee(Employee employee) {
		em.persist(employee);
		logger.info("Employee inserted!");
	}

	/**
	 * This method is for @Entity and @Inheritance example
	 * @return
	 */
	/*
	 * public List<Employee> retrieveAllEmployees() { List<Employee> employees =
	 * em.createQuery("select employee from Employee employee", Employee.class)
	 * .getResultList(); return employees; }
	 */

	/**
	 * This method is for @MappedSuperClass example
	 * @return
	 */
	public List<PartTimeEmployee> retreiveAllPartTimeEmployees() {
		return em.createQuery("select pe from PartTimeEmployee pe", PartTimeEmployee.class).getResultList();
	}
	
	/**
	 * This method is for @MappedSuperClass example
	 * @return
	 */
	public List<FullTimeEmployee> retreiveAllFullTimeEmployees() {
		return em.createQuery("select pe from FullTimeEmployee pe", FullTimeEmployee.class).getResultList();
	}

}
