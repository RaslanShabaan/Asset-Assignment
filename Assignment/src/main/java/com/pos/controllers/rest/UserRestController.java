package com.pos.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.entities.Users;
import com.pos.services.UsersService;

//user controller
@RestController
@RequestMapping("/User")
public class UserRestController {
	@Autowired
	UsersService usersservice;

// insert new user
	@PostMapping("/AddUser")
	public ResponseEntity<Users> AddUser(@RequestBody Users users) {
		return usersservice.AddUser(users);
	}

//update  user
	@PutMapping("/UpdateUser")
	public ResponseEntity<Users> UpdateUser(@RequestBody Users Users) {
		return usersservice.UpdateUser(Users);
	}
}
