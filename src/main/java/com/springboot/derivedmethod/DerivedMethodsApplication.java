package com.springboot.derivedmethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
		// getUserByIds();
		// findByFirstName();
		//findByFirstNameAndLastName();
		// findByFirstNameOrLastName();
		
		//findByLastNameOrderByCreationDateDesc();
		//findByAgeLessThanEqual();
		//findByLastNameAndAgeLessThanEqual();
		///findByFirstNameLike();
		//findByCreatedDateBetween();
		findByCreatedDateBetweenwithTime();
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

	private void getUserByIds() {
		List<Integer> UserList = new ArrayList<Integer>();
		UserList.add(1);
		UserList.add(2);
		UserList.add(12);
		UserList.add(5);
		UserList.add(6);
		UserList.add(20);
		UserList.add(40);
		UserList.add(11);
		UserList.add(15);
		UserList.add(3);
		UserList.add(4);
		Iterable<User> usersList = userService.findUsers(UserList);
		for (User user : usersList) {
			System.out.println("User Object" + user.toString());

		}
	}

	private void findByFirstName() {
		Iterable<User> UsersList = userService.findByFirstName("Ram");
		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		User userObj = userService.findByFirstNameAndLastName("Ram", "kumar");

		System.out.println("User Object" + userObj.toString());

	}

	private void findByFirstNameOrLastName() {
		Iterable<User> UsersList = userService.findByFirstNameOrLastName("Sita", "kumar");

		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}

	}

	// findByLastNameOrderByCreationDateDesc
	private void findByLastNameOrderByCreationDateDesc() {
		Iterable<User> UsersList = userService.findByLastNameOrderByCreatedDateDesc("kumar");

		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}

	}
	
	
	private void findByAgeLessThanEqual() {
		Iterable<User> UsersList = userService.findByAgeLessThanEqual(40);

		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}

	}

	
	private void findByLastNameAndAgeLessThanEqual() {
		Iterable<User> UsersList = userService.findByLastNameAndAgeLessThanEqual("kumar",40);

		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}

	}
	

	private void findByFirstNameLike() {
		Iterable<User> UserList = userService.findByFirstNameLike("%Kiran%");

		for (User User : UserList) {
			System.out.println(User.toString());
		}
	}

	

	

	
	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}
	private Date getDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private Date getDate(String dateString, int add) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date current = format.parse(dateString);

			Calendar cal = Calendar.getInstance();
			cal.setTime(current);
			cal.add(Calendar.DATE, add);

			return cal.getTime();
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private void findByCreatedDateBetweenwithTime() {
		//2020-07-09 19:18:40.271000
		Iterable<User> UsersList = userService.findByCreatedDateBetween(getDatewithTime("2020-07-09 19:18:00"), getDatewithTime("2020-07-09 19:18:41"));

		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}

	}
	
	
	

	private void findByCreatedDateBetween() {
		Iterable<User> UsersList = userService.findByCreatedDateBetween(getDate("2020-05-10"), getDate("2020-07-10"));

		for (User User : UsersList) {
			System.out.println("User Object" + User.toString());

		}

	}

}
