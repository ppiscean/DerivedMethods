package com.springboot.derivedmethod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.derivedmethod.dao.UserDao;
import com.springboot.derivedmethod.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public Iterable<User> saveAllUsers(Iterable<User> usersList){
		
		return userDao.saveAll(usersList);
		
		
	}

	
	public Iterable<User> findUsers(Iterable<Integer> usersList){
		
		return userDao.findAllById(usersList);
		
		
	}
	
	
	public List<User> findByFirstName(String firstName)
	{
		return userDao.findByFirstName(firstName);
	}
	
	public User findByFirstNameAndLastName(String firstName, String lastName)
	{
		return userDao.findByFirstNameAndLastName(firstName,lastName);
	}


	public Iterable<User> findByFirstNameOrLastName(String firstName, String lastName) {
		return userDao.findByFirstNameOrLastName(firstName,lastName);
	}


	public Iterable<User> findByLastNameOrderByCreatedDateDesc(String lastName) {
		return userDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}
	
	
	
	
}

