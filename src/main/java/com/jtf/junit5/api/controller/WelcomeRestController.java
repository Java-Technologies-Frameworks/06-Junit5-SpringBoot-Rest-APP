package com.jtf.junit5.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtf.junit5.api.service.WelcomeService;

@RestController
public class WelcomeRestController {

	@Autowired
	private WelcomeService welcomeService;
	
	@GetMapping("/test")
	public ResponseEntity<String> welcomeMessage(){
		String messg = welcomeService.getMessage();
		return new ResponseEntity<String>(messg,HttpStatus.OK); 
 	}
}
