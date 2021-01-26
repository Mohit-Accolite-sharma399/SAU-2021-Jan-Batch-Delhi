package org.mohit.REST.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mohit.REST.model.Person;
import org.mohit.REST.service.PersonService;

@Path("/persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonDetail {

	PersonService personService= new PersonService();
	
	@GET
	public List<Person> getPerson() {
		return personService.getAllPerson();
	}
	
	@POST
	public Person addPerson(Person person) {
		return personService.addPerson(person);
	}
	
	@PUT
	@Path("/{personId}")
	public Person updatePerson(@PathParam("personId") long id, Person person) {
		person.setId(id);
		return personService.updatePerson(person);
	}
	
	@DELETE
	@Path("/{personId}")
	public void deletePerson(@PathParam("personId") long id) {
		personService.removePerson(id);
	}
	
	
	@GET
	@Path("/{personId}")
	public Person getPerson(@PathParam("personId") long id) {
		return personService.getPerson(id);
	}
}
