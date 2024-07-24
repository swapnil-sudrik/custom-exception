package com.crud.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.entities.User;

public interface UserService {
	
	ResponseEntity<Object> addUser(User user);
	
	ResponseEntity<Object> updateUser(User user, long id);
	
	ResponseEntity<Object> deleteUser(long id);
	
	List<User> getAllUsers();
	

}
