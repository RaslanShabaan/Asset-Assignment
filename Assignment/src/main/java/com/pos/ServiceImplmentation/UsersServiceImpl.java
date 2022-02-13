package com.pos.ServiceImplmentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.entities.Movie;
import com.pos.entities.Users;
import com.pos.repositories.UsersRepository;
import com.pos.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;

	@Override
	public List<Users> getUser() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Users getUserById(long id) {
		// TODO Auto-generated method stub
		return usersRepository.getOne(id);
	}

	@Override
	public Users insertUser(Users obj) {
		// TODO Auto-generated method stub
		return usersRepository.save(obj);
	}

	@Override
	public Users updateUser(Users obj) {
		// TODO Auto-generated method stub
		return usersRepository.save(obj);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
	}

	@Override
	public List<Users> findUserByName(String name) {
		return usersRepository.findUserByName(name);
	}

	@Override
	public List<String> getAllnames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return usersRepository.findUserByNameAndPassword(name, password);
	}

	@Override
	public ResponseEntity AddUser(Users obj) {

		if (obj.getCreatedby() == null || obj.getIsactive() == null || obj.getUsername() == null || obj.getPassword() == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		} else {
			Users Users = usersRepository.save(obj);
			return new ResponseEntity(Users, HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity UpdateUser(Users obj) {
		if (obj.getCreatedby() == null || obj.getIsactive() == null || obj.getUsername() == null || obj.getPassword() == null || obj.getUsers_id() == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		} else {
			Users users= usersRepository.save(obj);
			return new ResponseEntity(users, HttpStatus.OK);
		}
		
	}

}
