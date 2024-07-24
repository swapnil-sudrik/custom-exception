package com.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.User;
import com.crud.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		return this.service.addUser(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id){
		return this.service.updateUser(user, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable long id){
		return this.service.deleteUser(id);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return this.service.getAllUsers();	
	}
	
}
