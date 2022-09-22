package com.citi.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.system.dto.User;
import com.citi.system.repository.UserRepository;

@Component("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;

	@Override
	public boolean verifyUser(User user) { 
		return userRep.verifyUser(user);
	}

}
