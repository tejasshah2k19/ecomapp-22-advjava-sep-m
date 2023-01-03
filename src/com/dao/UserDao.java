package com.dao;

import java.util.ArrayList;

import com.bean.UserBean;

public class UserDao {

	private static ArrayList<UserBean> users = new ArrayList<UserBean>();// 1 time

	static {
		UserBean user1 = new UserBean();
		user1.setEmail("a@a.com");
		user1.setFirstName("a");
		user1.setPassword("a");

		UserBean user2 = new UserBean();
		user2.setEmail("b@b.com");
		user2.setFirstName("b");
		user2.setPassword("b");

		UserBean user3 = new UserBean();
		user3.setEmail("c@c.com");
		user3.setFirstName("c");
		user3.setPassword("c");

		users.add(user1);
		users.add(user2);
		users.add(user3);

		
		//users.removeIf(u->u.getUserId() == 7);
		//A cartd = new ; 
		//cart loop->c.getUserId != loginuserId 
		//cartd.add(c)
		//carts = cartd; 
		
	}

	public void addUser(UserBean user) {
		users.add(user);
	}

	public ArrayList<UserBean> getAllUsers() {
		return users;
	}

	// null -> if credentials is wrong
	// userBean -> if credentials is correct
	public UserBean login(String email, String password) {
		UserBean user = null;
		
		for (UserBean u : users) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				user = u;
				System.out.println("gottt");
				break;
			}
		}

		return user;
	}

}
