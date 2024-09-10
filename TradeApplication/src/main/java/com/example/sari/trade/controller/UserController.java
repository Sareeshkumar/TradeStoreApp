package com.example.sari.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sari.trade.model.User;
import com.example.sari.trade.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;


	//1. save User data in DB
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(
			@RequestBody User user)	
	{
		Integer id = service.saveUser(user);
		String body = "User '"+id+"' saved";
		return new ResponseEntity<String>(body, HttpStatus.OK);
		// return ResponseEntity.ok(body);
	}

}
