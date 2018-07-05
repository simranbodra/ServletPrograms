package com.bridgelabz.servlets.repository;

import java.sql.Connection;

import com.bridgelabz.servlets.model.User;

public interface UserRepository {

	public Connection getDatabaseAccess();
	public User getUser(String emailId, String password, Connection connection);
	public boolean checkUserInDatabase(String emailId, Connection connection);
	public boolean registerUser(User user, Connection connection);
	
}
