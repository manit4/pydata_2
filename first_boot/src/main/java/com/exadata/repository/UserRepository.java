package com.exadata.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.exadata.dto.LoginTo;
import com.exadata.dto.User;

@Repository
public class UserRepository {
	
	List<User> users = null;
	
	public UserRepository() {
		
		User user1 = new User(100, "Jiangwei", 111111);
		User user2 = new User(101, "Gary", 222222);
		User user3 = new User(102, "Mani", 333333);
		
		users = new ArrayList<User>();
		users.add(user1);  users.add(user2);   users.add(user3);
	}
	
	public List<User> findAllUsers() {
		
		System.out.println("insdie findAllUsers in UserRepository...");
		
		return users;
	}
	
	public User getUserById(long id) {
		
		for(User user : users) {
			
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	public void addUser(User user) {
		
		users.add(user);
	}
	
//	public List<User> getUserLessThan5() {
//		
//		List<User> filteredUsers = null;
//		
//		for(User user : users) {
//			System.out.println("1");
//			if(user.getName().length() < 5) {
//				System.out.println("2");
//				filteredUsers = new ArrayList<User>();
//				filteredUsers.add(user);
//			}
//		}
//		System.out.println("FilteredUsers "+filteredUsers);
//		
//		return filteredUsers;
//	}
	
	public User findUserByIdAndPassword(LoginTo loginTo) {
		
		User fetchedUser = null;
		
		for(User user : users) {
			
			if(user.getId() == loginTo.getId() && user.getPhone() == loginTo.getPhone()) {
				fetchedUser = user;
			}
		}
		return fetchedUser;
	}
	
	

}
