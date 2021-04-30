package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.model.User;
import com.example.model.UserCredentials;
import com.example.repo.UserRepo;
import com.example.util.TokenUtil;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	TokenUtil util;
	@Autowired
	UserRepo repo;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Request Intercepted...");
		boolean isAuthorized=false;
		String uri=request.getRequestURI();
		String token=request.getHeader("Authorization");
		if(token!=null) {
		UserCredentials cred=util.decode(token);
		User loggedInUser= repo.getOne(cred.getUserId());
		
		if(loggedInUser==null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		if(uri.contains("/secure/")) {
			isAuthorized=true;
		}
		}
	
		if(uri.contains("/public/")) {
		isAuthorized=true;
		}
		if(!isAuthorized) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		return isAuthorized;
	}
	
}
