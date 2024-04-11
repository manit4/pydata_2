package com.exadata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadata.dto.LoginTo;
import com.exadata.dto.User;
import com.exadata.repository.UserRepository;
import com.exadata.service.UserService;

//@Controller//If the response is in html then the class must be annotated with @Controller
@RestController//If the response is in plain text/json/xml then the class must be annotated with @RestController
				//and the mapping methods are called as Rest-Endpoints
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/msg")//This is Rest End-point, Rest End-point API means the response is in either
						//Plain Text/Json/XML but not HTML
	public String getessage() {//This is rest end-point...
		System.out.println("inside getMessage mapping method...");
		
		return "hello class jenkins and updating file....";
	}
	
//	@RequestMapping("/getUser")
//	public User getUser() {//This is Rest End-point
//		
//		System.out.println("inside getUser mapping method....");
//		
//		User user = new User(101, "Jiangwei", 111111);
//		
//		return user;
//	}
	
//	@RequestMapping("/getAllUsers")
//	public List<User> getAllUsers() {//This is Rest End-point
//		
//		User user1 = new User(100, "Jiangwei", 111111);
//		User user2 = new User(101, "Gary", 222222);
//		User user3 = new User(102, "Manisai", 333333);
//		
//		List<User> users = new ArrayList<User>();
//		
//		users.add(user1);   users.add(user2);  users.add(user3);
//		
//		return users;
//	}
	
	@RequestMapping("/getAllUsers")
	public List<User> getUsers() {
		
		System.out.println("inside UserController");
		
		return userService.fetchAllUsers();
	}
	
	@RequestMapping("/getUser/{id}")
	public User getUserById(@PathVariable int id) {
		
		System.out.println("The id fetched from the request is "+id);
		
		User user = userService.findUserById(id);
		
		System.out.println("User in the controller is "+user);
		
		return user;
	}
	
	@GetMapping("/lessThan5")
	public List<User> getUsersLessThan5() {
		
		System.out.println("Controller  is "+userService.fetchUsersLessThan5());
		
		return userService.fetchUsersLessThan5();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String regsiter(@RequestBody User user) {//This "RequestBody annotation is used to receive data coming
							//in JSON format...
		
		String message = null;
		System.out.println("User is "+user);
		
		boolean status = userService.addUser(user);
		
		if(status == true) {
			message = "User Added Successfully";
		}
		else {
			message = "User already Exists";
		}
		
		return message;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginTo loginTo) {
		
		String message = "Login Falied, please try again...";
		
		System.out.println("Id and phone are "+loginTo.getId()+", "+loginTo.getPhone());
		
		User user = userService.login(loginTo);
		
		if(user != null) {
			
			message = "Login Successfull";
		}
		
		return message;
		
	}
	
	
	
	
	

}
