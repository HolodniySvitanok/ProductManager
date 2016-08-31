package com.holodniysvitanok.productmanager.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class AuthorizationAndRegistrationController {
	
	
	
	
	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String authorization(HttpServletRequest request) {
		return "authorization";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(HttpServletRequest request) {
		return "registration";
	}
	
	
	
}
