package com.pos.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.entities.Users;

public interface UsersService {
	public List<Users> getUser();
	Users findUserByNameAndPassword(String name,String password);
	public Users getUserById(long id);
	public Users insertUser(Users obj);
	public Users updateUser(Users obj);
	public void deleteUserById(long id);
	public List<Users> findUserByName(String name);
	public List<String> getAllnames();
	public ResponseEntity AddUser(Users obj);
	public ResponseEntity UpdateUser(Users obj);
}
