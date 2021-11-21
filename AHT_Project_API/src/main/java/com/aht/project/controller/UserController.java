package com.aht.project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.User;
import com.aht.project.entity.Role;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.UserRepository;
import com.aht.project.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	private UserRepository userRepository;
	private UserServiceImpl userServiceImpl;

	public UserController(UserRepository userRepository, UserServiceImpl userServiceImpl) {
		this.userRepository = userRepository;
		this.userServiceImpl = userServiceImpl;
	}
	
	@GetMapping
	public ResponseEntity<Object> getAll() {
		ServiceResult serviceResult = userServiceImpl.findAll();
		List<User> users = (List<User>) serviceResult.getData();
		if (users.size() > 0) {
			return new ResponseEntity<>(serviceResult, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}	
	
	@PostMapping("/checkUser")
	public ResponseEntity<Object> check(@RequestBody User user) {
		System.out.print(user.getEmail());
		ServiceResult serviceResult = userServiceImpl.getUser(user);
		if (!serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult,HttpStatus.OK);
		}
		return new ResponseEntity<>(serviceResult,HttpStatus.OK);

	}	
	
	@GetMapping("/all")
	public Set<Role> getAllRoles() {
		return userRepository.findById(1).get().getRoles();
	}

	@PostMapping
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		System.out.print(user.getName());
		ServiceResult serviceResult = userServiceImpl.save(user);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
		ServiceResult serviceResult = userServiceImpl.delete(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		ServiceResult serviceResult = userServiceImpl.update(user);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
