package com.springboot.derivedmethod.service;

import java.util.Date;
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
	
	public Iterable<User> findByFirstNameLike(String firstName) {
		return userDao.findByFirstNameLike(firstName);
	}
	
	
	public List<User> findByLastNameAndAgeLessThanEqual(String lastName,int age)
	{
		return userDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	}
	
	public List<User> findByCreatedDateBetween(Date startdate,Date endDate)
	{
		return userDao.findByCreatedDateBetween(startdate,endDate);
	}

	public List<User> findByAgeLessThanEqual(Integer age) {
		return userDao.findByAgeLessThanEqual(age);
	}
	
	
	
}

