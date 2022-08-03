
package com.learn.springboot.jdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learn.springboot.jdbc.entity.Person;

@Repository
public class PersonJbdcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * @author esliv
	 * This is for creating a custom row mapper. 
	 * We can use custom row mapper when the Table definition is not the 
	 * same as entity definition.
	 *
	 */
	class PersonRowMapper implements RowMapper<Person> {
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setLocation(rs.getString("location"));
			person.setName(rs.getString("name"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	public List<Person> findAll() {
		//return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
		//Using cutomised row mapper PersonRowMapper
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	@SuppressWarnings("deprecation")
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	@SuppressWarnings("deprecation")
	public Person findByName(String name) {
		Person byName = jdbcTemplate.queryForObject("select * from Person where name = ?", new Object[] { name },
				new BeanPropertyRowMapper<Person>(Person.class));
		return byName;
	}

	public int deleteById(int id, String name) {
		return jdbcTemplate.update("delete from person where id=? and name=?", new Object[] { id, name });
	}

	public int insertIntoPerson(Person person) {
		int insertion = jdbcTemplate.update("insert into Person(id, name, location, birth_date) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
		return insertion;

	}

	public int updatePerson(Person person) {
		int udpate = jdbcTemplate.update("update Person set name = ?, location = ?, birth_date = ? where id = ? ",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
		return udpate;
	}
}
