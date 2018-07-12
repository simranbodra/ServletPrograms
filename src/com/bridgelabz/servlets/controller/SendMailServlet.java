package com.bridgelabz.servlets.controller;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
      
      
public class SendMailServlet extends HttpServlet{
	
	final String admin = "simranbodra9619@gmail.com";
	final String passwordAdmin = "simran96";
	
    public void doGet(HttpServletRequest request,HttpServletResponse response)  
        throws ServletException, IOException {  
    	System.out.println("********************* Inside sendmailservice");
		
    	String email = request.getParameter("email");
		
		Mailer.send(email, admin, passwordAdmin);
		System.out.println("Redirecting to ResetPasswordServlet......................");
		response.sendRedirect("PasswordServlet");
    }  
}

