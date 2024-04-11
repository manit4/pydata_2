package com.exadata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exadata.dto.LoginTo;
import com.exadata.dto.User;
import com.exadata.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> fetchAllUsers() {
		
		System.out.println("insdie FetchUsers() of UserService");
		
		return userRepository.findAllUsers();
	}
	
	public User findUserById(long id) {
		
		return userRepository.getUserById(id);
	}
	
	public List<User> fetchUsersLessThan5() {
	
		List<User> users = userRepository.findAllUsers();
		
		List<User> filteredList = new ArrayList<User>();;
		
		for(User user : users) {
			
			if(user.getName().length() < 5) {
				
				filteredList.add(user);
			}
		}
		
		return filteredList;
	}
	
	public boolean addUser(User user) {
		
		boolean status = true;
		
		List<User> users = userRepository.findAllUsers();
		
		for(User value : users) {
			
			if(value.getId() == user.getId()) {
				status = false;
				break;
			}
		}
		if(status == true) {
			userRepository.addUser(user);
		}
		return status;
	}
	
	public User login(LoginTo loginTo) {
		
		return userRepository.findUserByIdAndPassword(loginTo);
	}

}
