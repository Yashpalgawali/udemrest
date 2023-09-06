package com.example.demo.usersrestservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	
	@Autowired
	UserDAOService userdao;

	
	public UserController(UserDAOService userdao)
	{
		this.userdao=userdao;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userdao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Integer id)
	{
		return userdao.findById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User us = userdao.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand(null)
		return ResponseEntity.created(location).build();
		
	}
}
