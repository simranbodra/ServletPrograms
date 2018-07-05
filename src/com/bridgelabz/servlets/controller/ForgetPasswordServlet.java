package com.bridgelabz.servlets.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgetPasswordServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7564793950464545251L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispature = req.getRequestDispatcher("forgetpassword.jsp");
		dispature.forward(req, resp);
	}

}
