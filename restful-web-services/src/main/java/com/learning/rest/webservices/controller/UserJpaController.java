package com.learning.rest.webservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.learning.rest.webservices.service.dao.UserRepository;

@RestController
public class UserJpaController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/jpa/users")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/jpa/users/{id}")
	public User findOneUser(@PathVariable Integer id) throws NoSuchMethodException, SecurityException{
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) throw new UserNotFoundEception("Unable to FindUser with Id-"+id);
		return user.get();
	}
	
	@PostMapping(value = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User persistedUser =  userRepository.save(user);
		
		URI uri =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(persistedUser.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		userRepository.deleteById(id);
	}

}
