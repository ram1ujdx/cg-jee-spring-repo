package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.example.util.TokenUtil;
import com.example.model.Token;
import com.example.model.User;
import com.example.model.UserCredentials;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonValue;

@RestController
@CrossOrigin
public class AuthController {

	@Autowired
	UserRepo repo;
	@Autowired
	TokenUtil util;
	

	@PostMapping("/public/users")
	public User addUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	

	
	@PostMapping("/public/login")
	public Token authenticate(@RequestBody UserCredentials cred) {
		User u=repo.getOne(cred.getUserId());
		
		
			if(u!=null && cred.getPassword().equals(u.getPassword())) {
				return new Token(util.generateToken(cred));
			
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
	}
}
