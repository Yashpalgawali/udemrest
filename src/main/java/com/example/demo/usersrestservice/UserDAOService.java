package com.example.demo.usersrestservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int count = 0;
	
	static {
		users.add(new User(++count,"Samrat", LocalDate.now()));
		users.add(new User(++count,"Sumedh",  LocalDate.now().minusYears(15)));
		users.add(new User(++count,"Avirat",  LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id)
	{
		Predicate<? super User > predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteUserById(int id) {
		Predicate<? super User > predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	public User saveUser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
}
