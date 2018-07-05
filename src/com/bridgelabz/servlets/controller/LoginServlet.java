package com.bridgelabz.servlets.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String id = (String)request.getAttribute("id");
		String phonenumber = (String)request.getAttribute("phonenumber");
		
		System.out.println(id);
		
		HttpSession session=request.getSession(true);
		System.out.println("Session is created");
		session.setAttribute("serialNum", id);
		session.setAttribute("name", name);
		session.setAttribute("mobileNum", phonenumber);
		session.setAttribute("emailId", email);
		RequestDispatcher dispatch=request.getRequestDispatcher("DisplayData.jsp");
		dispatch.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
