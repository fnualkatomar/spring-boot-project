package com.learning.rest.webservices.service.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.rest.webservices.bean.User;

@Component
public class UserDaoService {
	
	private static List<User> usersList = new ArrayList<User>();
	private static int usersCount = 4;
	
	static {
		usersList.add(new User(1, "Shiv Ratan", new Date()));
		usersList.add(new User(2, "Alka Tomar", new Date()));
		usersList.add(new User(3, "Vedant Pundir", new Date()));
		usersList.add( new User(4, "Viansh Pundir", new Date()));
	}
	
	public List<User> findAllUsers() {		
		return usersList;
	}
	
	public User saveUsers(User user) {		
		if(user.getId()==null) {
			user.setId(++usersCount);
			user.setBirthDate(new Date());
		}
		usersList.add(user);
		return user;
	}
	
	public User findUserById(Integer id) {		
		for (User user : usersList) {
			if(user.getId()==id) {
				return user;
			}
		}		
		return null;
	}

	public User deleteUserById(Integer id) {
		Iterator<User> userIterator = usersList.iterator();
		while(userIterator.hasNext()) {
			User user = userIterator.next();
			if(user.getId()==id) {
				userIterator.remove();
				return user;
			}
			
		}
		return null;
	}

}
