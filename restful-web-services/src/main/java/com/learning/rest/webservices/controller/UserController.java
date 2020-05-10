package com.learning.rest.webservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.webservices.bean.User;
import com.learning.rest.webservices.exception.UserNotFoundEception;
import com.learning.rest.webservices.service.dao.UserDaoService;

@RestController
public class UserController {
	
	@Autowired
	UserDaoService userDao;
	
	@GetMapping(value = "/users")
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}
	
	@GetMapping(value = "/users/{id}")
	public User findOneUser(@PathVariable Integer id){
		User user = userDao.findUserById(id);
		if(user == null) throw new UserNotFoundEception("Unable to FindUser with Id-"+id);
		return user;
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User persistedUser =  userDao.saveUsers(user);
		
		URI uri =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(persistedUser.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		User deletedUser = userDao.deleteUserById(id);
		if(deletedUser == null) throw new UserNotFoundEception("Unable to FindUser with Id-"+id);
	}

}
