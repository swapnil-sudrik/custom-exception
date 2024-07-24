package com.crud.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.entities.User;
import com.crud.reporistories.UserRepo;
import com.crud.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public ResponseEntity<Object> addUser(User user) {
		try {
			userRepo.save(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			Map<String, String> respose = new HashMap<>();
			respose.put("message", "User Not Added ! Server down");
			return new ResponseEntity<>(respose, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Object> updateUser(User user, long id) {
		
		Optional<User> user2 = userRepo.findById(id);
			
		if (user2.isPresent()) {
			User findUser = user2.get();
			
			findUser.setUserAddress(user.getUserAddress());
			findUser.setUserName(user.getUserName());
			userRepo.save(findUser);
			return new ResponseEntity<>(findUser, HttpStatus.OK);
		}else {
			Map<String, String> response = new HashMap<>();
			response.put("message", "User not found with this is: "+id);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Object> deleteUser(long id) {
		Optional<User> user2 = userRepo.findById(id);
		
		if (user2.isPresent()) {

			userRepo.deleteById(id);
			Map<String, String> response = new HashMap<>();
			response.put("message", "User deleted success with this is: "+id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
			else {
			Map<String, String> response = new HashMap<>();
			response.put("message", "User not found with this is: "+id);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list  = userRepo.findAll();
		return list;
	}

}
