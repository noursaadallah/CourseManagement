package com.univ.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.univ.model.Course;

@Entity
public class Professor extends User {

	@OneToMany(cascade= CascadeType.ALL , mappedBy="professor")
	@JsonIgnore
	protected Collection<Course> courses ;
	
	public Professor() {
		super();
		this.courses = new ArrayList<Course>();
	}

	@JsonCreator
	public Professor(@JsonProperty("firstName") String firstName, 
					@JsonProperty("lastName") String lastName,
					@JsonProperty("email") String email, 
					@JsonProperty("password") String password) {
		super(firstName , lastName, email , password);
		this.courses = new ArrayList<Course>();
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
	public void removeCourse(Course c) {
		this.courses.remove(c);
	}
	
}
