package com.bridgelabz.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Logout");
		HttpSession session=req.getSession(false); 
		if(session!=null) {
			session.invalidate();
			PrintWriter out = resp.getWriter();
			out.print("<html><p>Logged out successfully</p></html>");
			req.setAttribute("errMessage", "You have logged out successfully");
			RequestDispatcher dispatch=req.getRequestDispatcher("Home.jsp");
			dispatch.include(req, resp);
			System.out.println("Logged Out");
		}
    }
}
