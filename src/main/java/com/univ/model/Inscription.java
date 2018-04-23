package com.univ.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.univ.model.Course;
import com.univ.model.Student;

@Entity
public class Inscription {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	@ManyToOne
	protected Course course;
	@ManyToOne
	protected Student student;
	
	public Inscription() {
		super();
	}
	
	public Inscription(Course course, Student student) {
		super();
		this.course = course;
		this.student = student;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Inscription))return false;
	    Inscription _other = (Inscription)other;
	    if(_other.id == this.id) return true;
	    return false;
	}
}
