package com.pos.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.entities.Users;
import com.pos.repositories.UsersRepository;
import com.pos.restpojo.AuthRequest;
import com.pos.restpojo.ResponseBody;
import com.pos.security.JwtUtil;

// authentication controller
@RestController
@RequestMapping(value = "/authenticate")
public class AuthenticatedController {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

// authentication request
	@PostMapping("")
	public com.pos.restpojo.ResponseBody generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		if (authRequest.getUserName() == null || authRequest.getUserName().equals("")
				|| authRequest.getPassword() == null || authRequest.getPassword().equals("")) {
// missing data 
			return new ResponseBody(HttpStatus.BAD_REQUEST.value(), "0", System.currentTimeMillis(), 0, null, null);

		} else {
			// search for user by user name and password
			try {
				Users currentUser = usersRepository.findbyuserandpass(authRequest.getUserName(),
						authRequest.getPassword());
// user found
				if (currentUser != null) {
					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							authRequest.getUserName(), authRequest.getPassword()));
					return new com.pos.restpojo.ResponseBody(HttpStatus.ACCEPTED.value(), "0",
							System.currentTimeMillis(), 1, currentUser.getUsers_id() + "",
							jwtUtil.generateToken(authRequest.getUserName()));
				} else {
					// user not found
					return new com.pos.restpojo.ResponseBody(HttpStatus.BAD_REQUEST.value(), "0",
							System.currentTimeMillis(), 0, null);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				if (ex.getMessage().equals("0")) {
					return new com.pos.restpojo.ResponseBody(HttpStatus.BAD_REQUEST.value(), "0",
							System.currentTimeMillis(), 0, null);
				} else {
					return new com.pos.restpojo.ResponseBody(HttpStatus.BAD_REQUEST.value(), "0",
							System.currentTimeMillis(), 0, null);
				}
			}
		}
	}

}
