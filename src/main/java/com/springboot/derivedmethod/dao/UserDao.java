package com.springboot.derivedmethod.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.derivedmethod.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	
	// If we want to get the data from person table based on firstName
	// findByFirstName -> "findBy" -> Prefix and Propertyname -> suffix
	// Camelcase Notation
	// Internaly , it writes select * from person_table where first_name=?firstName
	public List<User> findByFirstName(String firstName);
	
	
	// And KeyWord
	// If we want to retrieve the data using more than one column then we can use
	// And Keyword.
	// JPQL -> select * from person where firstName=?1 and lastName=?2
	public User findByFirstNameAndLastName(String firstName, String lastName);
	
	

	// OR KeyWord
	// If we want to retrieve the data using more than one column then we can use
	// OR Keyword.
	// JPQL -> Select * from person where firstName=?1 or lastName=?2
	public List<User> findByFirstNameOrLastName(String firstName, String lastName);
			
	
	
	// OrderBy
	// This will does sorting based on columnName
	// select * from person where lastName=?1 order by lastName desc;
	// selet * from person where lastName=?1 order by creationDate desc;
	//findBy
	//LastName
	//OrderBy
	//CreatedDate
	//Desc
	
	public List<User> findByLastNameOrderByCreatedDateDesc(String lastName);
	
	
	// LessThanEqual
	// It will filter the data only one column
	// It applies <= operator in the JPQL and SQL Query
	//JPQL -> Select * from person where age<=?1
	public List<User> findByAgeLessThanEqual(Integer age);
	
	

	// LikeSerach
	// We need to manually append % symbol before calling this api
	// select * from person where firstName like '%?%'
	public List<User> findByFirstNameLike(String firstName);
	
	
	
	
	//JPQL -> Select * from person where last_name=?1 and age<=?2
	//findBy
	//LastName -> ColumnName1
	//And -> keyword1
	//Age -> ColumnName2
	//LessThanEqual -> Keyword2
	public List<User> findByLastNameAndAgeLessThanEqual(String lastName,int Age);
	
	
	
	//JPQL -> Select * from person where createdate<=?1 and createddate>=?2
	public List<User> findByCreatedDateBetween(Date startdate,Date endDate);
	
	
	
	
	
	
	
	

}
