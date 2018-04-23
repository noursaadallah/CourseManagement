package com.univ.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


//!!!!!!!!!!!!!!!! Can't use Streams with JPA Entities !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
@Entity
public class Student extends User{
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="student")
	@JsonIgnore
	protected Collection<Inscription> inscriptions;
	protected int level;
	
	
	public Student() {
		super();
		inscriptions = new ArrayList<Inscription>();
	}
	
	@JsonCreator
	public Student( @JsonProperty("firstName") String firstName, 
					@JsonProperty("lastName") String lastName,
					@JsonProperty("email") String email, 
					@JsonProperty("password") String password, 
					@JsonProperty("level") int level ) {
		super(firstName, lastName, email, password);
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	public void addInscription(Inscription i) {
		this.inscriptions.add( i );
	}
	
	public void removeInscription(Inscription i) {
		this.inscriptions.remove(i);
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Student))return false;
	    Student _other = (Student)other;
	    if(_other.id == this.id) return true;
	    return false;
	}
	
	
}