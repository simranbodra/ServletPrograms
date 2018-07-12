package com.bridgelabz.servlets.repository;

import com.bridgelabz.servlets.model.User;

public interface UserRepository {

	public User getUser(String emailId, String password);
	public boolean saveUser(User user);
	
}
