package com.bridgelabz.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.servlets.model.User;
import com.bridgelabz.servlets.repository.UserRepositoryImpl;
import com.bridgelabz.servlets.repository.UserRepository;

public class RegistrationServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRepository dao = new UserRepositoryImpl();
		User user = new User();
		PrintWriter out=response.getWriter();
		
		user.setUserName(request.getParameter("name"));
		user.setPhoneNumber(Long.parseLong(request.getParameter("contact")));
		user.setEmailId(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setUserId(444);		
		Connection connection = dao.getDatabaseAccess();
		if(dao.registerUser(user, connection) == true) {
			out.print("<html><p>Login with your credentials..</p></html>");
			RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
			dispatch.include(request, response);
		}	
		else {
			out.print("<html><p>Error in registering... Try Again!! </p></html>");
			RequestDispatcher dispatch = request.getRequestDispatcher("register.jsp");
			dispatch.include(request, response);
		}
	}
}
