package org.mcp.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {

	public static void main(String[] args) {

		List<User> users = new ArrayList<>();
		
		// Initialize the list
		for(int i = 0; i<10; i++){
			users.add(new User("abc"+i));
		}
		
		Collections.shuffle(users);
		System.out.println(users);
		Collections.sort(users, (u1, u2) -> {
			return u1.getName().compareTo(u2.getName());
		});
		
		System.out.println(users);
	}

}

class User  {

	private String name;
	
	public User(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}