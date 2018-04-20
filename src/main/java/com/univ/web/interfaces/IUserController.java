package com.univ.web.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.univ.model.User;

@Controller
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public interface IUserController {
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody //return type is written to the HTTP response body (and not placed in a Model, or interpreted as a view name)
	public List<User> getUsers();
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody //return type is written to the HTTP response body (and not placed in a Model, or interpreted as a view name)
	public void createUser(@RequestParam(value="firstName")String firstName,
							@RequestParam(value="lastName")String lastName,
							@RequestParam(value="email")String email,
							@RequestParam(value="password")String password );
}
