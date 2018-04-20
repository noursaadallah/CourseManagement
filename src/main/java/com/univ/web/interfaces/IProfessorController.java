package com.univ.web.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.univ.model.Professor;

@Controller
@RequestMapping("professors")
@CrossOrigin(origins = "http://localhost:4200")
public interface IProfessorController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody 
	public List<Professor> getProfessors();
	
	@RequestMapping(method = RequestMethod.POST , consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void createProfessor(@RequestBody Professor p);
	
	@RequestMapping(value="/{email}/{password}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody 
	public Professor signIn( @PathVariable("email")String email,
							@PathVariable("password")String password );
}
