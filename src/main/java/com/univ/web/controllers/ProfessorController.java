package com.univ.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.univ.dal.ProfessorRepository;
import com.univ.model.Professor;
import com.univ.web.interfaces.IProfessorController;

@Controller
public class ProfessorController implements IProfessorController {

	ProfessorRepository pr = new ProfessorRepository();
	
	public List<Professor> getProfessors() {
		return pr.getProfessors();
	}

	public void createProfessor(@RequestBody Professor p) {
		pr.createProfessor(p);
	}

	public Professor signIn( @PathVariable("email")String email,
							 @PathVariable("password")String password ) {
		return pr.signIn(email, password);
	}
}
