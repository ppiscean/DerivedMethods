package com.springboot.derivedmethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.derivedmethod.model.User;
import com.springboot.derivedmethod.service.UserService;

@SpringBootApplication
public class DerivedMethodsApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createUsers();
		// getPersonByIds();
		// findByFirstName();
		//findByFirstNameAndLastName();
		// findByFirstNameOrLastName();
		
		findByLastNameOrderByCreationDateDesc();
	}

	private void createUsers() {

		/*
		 * 
		 * List<User> userNewList=new ArrayList<User>();
		 * 
		 * 
		 * User user1=new User("Kiran", "kumar", "kiran@gmail.com", 20);
		 * userNewList.add(user1);
		 * 
		 * 
		 * User user2=new User("Ram", "kumar", "ram@gmail.com", 22),
		 * userNewList.add(user2);
		 * 
		 */

		List<User> UserList = Arrays.asList(new User("Kiran", "kumar", "kiran@gmail.com", 20),
				new User("Ram", "kumar", "ram@gmail.com", 22), new User("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new User("Lakshamn", "Seth", "seth@gmail.com", 50), new User("Sita", "Kumar", "lakshman@gmail.com", 50),
				new User("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new User("KiranKiran", "kumar", "kiran@gmail.com", 20),
				new User("RamRam", "kumar", "ram@gmail.com", 22),
				new User("RamKiranRamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new User("RamKiranRamKiran", "Seth", "seth@gmail.com", 50),
				new User("SitaSita", "Kumar", "lakshman@gmail.com", 50),
				new User("GaneshSita", "Kumar", "ganesh@gmail.com", 50));

		Iterable<User> list = userService.saveAllUsers(UserList);
		for (User User : list) {
			System.out.println("User Object" + User.toString());

		}

	}

	private void getPersonByIds() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		Iterable<User> usersList = userService.findUsers(personList);
		for (User user : usersList) {
			System.out.println("Person Object" + user.toString());

		}
	}

	private void findByFirstName() {
		Iterable<User> personsList = userService.findByFirstName("Ram");
		for (User person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		User userObj = userService.findByFirstNameAndLastName("Ram", "kumar");

		System.out.println("Person Object" + userObj.toString());

	}

	private void findByFirstNameOrLastName() {
		Iterable<User> personsList = userService.findByFirstNameOrLastName("Sita", "kumar");

		for (User person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	// findByLastNameOrderByCreationDateDesc
	private void findByLastNameOrderByCreationDateDesc() {
		Iterable<User> personsList = userService.findByLastNameOrderByCreatedDateDesc("kumar");

		for (User person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

}
