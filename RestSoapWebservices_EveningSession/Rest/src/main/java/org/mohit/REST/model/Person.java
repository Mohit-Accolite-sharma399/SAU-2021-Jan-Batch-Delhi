package org.mohit.REST.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	private long id;
	private String name;
	private String DateOfBirth;
	private String address;
	
	public Person() {
	
	}
	
	public Person(long id, String name, String address,String DOB) {
		this.id = id;
		this.name = name;
	    DateOfBirth = DOB ;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
