package com.example.demo.usersrestservice;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exceptions.UserNotFoundException;

@RestController
public class UserController {

	
	@Autowired
	UserDAOService userdao;
	
	public UserController(UserDAOService userdao) 	{
		this.userdao=userdao;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userdao.findAll();
	}
	
//	@GetMapping("/users/{id}")
//	public User getUserById(@PathVariable("id") Integer id)
//	{
//		User user = userdao.findById(id);
//		if(user==null)
//			throw new UserNotFoundException("User Not FOund for ID "+id);
//		return user	;
//	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") Integer id)
	{
		User user = userdao.findById(id);
		if(user==null)
			throw new UserNotFoundException("User Not FOund for ID "+id);
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel	;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		userdao.deleteUserById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser( @RequestBody User user) {
		
		User us = userdao.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
