package com.citi.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.system.dto.User;
import com.citi.system.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api/user", method = {RequestMethod.GET, RequestMethod.POST})	
public class UserController {
	@Autowired
	UserService uServ; 
	
	@GetMapping("/userVerification")
	public boolean verifyUser(@RequestBody User user) {
		User u= new User(user.getUsername(), user.getPassword());
		System.out.println("INSIDE VERIFY USER "+u.toString());
		boolean isUserValid= uServ.verifyUser(u);
		System.out.println("isValid  "+isUserValid);
		return isUserValid;
	}

}
