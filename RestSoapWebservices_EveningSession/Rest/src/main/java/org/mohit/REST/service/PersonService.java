package org.mohit.REST.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mohit.REST.database.DatabaseClass;
import org.mohit.REST.model.Person;

public class PersonService {

	private Map<Long, Person> person= DatabaseClass.getPerson();
	
	public PersonService() {
		person.put(1L, new Person(1,"Mohit","Varansi","15-10-2000"));
		person.put(2L, new Person(2,"Kunal","Noida","3-10-2000"));
	}
	
	
	public List<Person> getAllPerson() {
		return new ArrayList<Person>(person.values());
	}
	
	public Person getPerson(long id) {
		return person.get(id);
	}
	
	public Person addPerson(Person person) {
		person.setId(((Map<Long, Person>) person).size() + 1);
		((Map<Long, Person>) person).put(person.getId(), person);
		return person;
	}
	
	public Person updatePerson(Person person) {
		if(person.getId() <= 0) {
			return null;
		}
		((Map<Long, Person>) person).put(person.getId(), person);
		return person;
	}
	
	public Person removePerson(long id) {
		return person.remove(id);
	}
	
}
