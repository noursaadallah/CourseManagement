package com.univ.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.univ.web.interfaces.IUserController;

import com.univ.dal.UserRepository;
import com.univ.model.User;

@Controller
public class UserController implements IUserController{
	
	UserRepository ur = new UserRepository();

	public List<User> getUsers(){
		return ur.getUsers();
	}
	
	public void createUser(@RequestParam(value="firstName")String firstName,
						@RequestParam(value="lastName")String lastName,
						@RequestParam(value="email")String email,
						@RequestParam(value="password")String password) {
		ur.addUser(firstName , lastName, email , password);
	}
}
