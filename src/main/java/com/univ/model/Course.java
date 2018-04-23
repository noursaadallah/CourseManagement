package com.univ.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.univ.model.Course;
import com.univ.model.Inscription;
import com.univ.model.Professor;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	protected String name;
	protected String description;
	protected int level;
	protected int capacity;
	protected Boolean available;
	@ManyToOne
	protected Professor professor;
	@OneToMany(cascade=CascadeType.ALL , mappedBy="course")
	@JsonIgnore
	protected Collection<Inscription> inscriptions;
	
	
	public Course() {
		super();
		this.available = true;
		this.inscriptions = new ArrayList<Inscription>();
	}

	@JsonCreator
	public Course( @JsonProperty("name") String name, 
				   @JsonProperty("description") String description, 
				   @JsonProperty("level") int level, 
				   @JsonProperty("capacity") int capacity) {
		super();
		this.name = name;
		this.description = description;
		this.level = level;
		this.capacity = capacity;
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
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	public void addInscription(Inscription i) {
		this.inscriptions.add(i);
	}
	
	public void removeInscription(Inscription i) {
		this.inscriptions.remove(i);
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Course))return false;
	    Course _other = (Course)other;
	    if(_other.id == this.id) return true;
	    if( !_other.name.equals(this.name) ) return false;
	    return false;
	}

}
