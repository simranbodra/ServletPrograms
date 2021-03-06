package com.bridgelabz.servlets.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.bridgelabz.servlets.repository.UserRepositoryImpl;
import com.bridgelabz.servlets.model.User;
import com.bridgelabz.servlets.repository.UserRepository;

public class LoginFilter implements Filter{

public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		UserRepository dao = new UserRepositoryImpl();
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("passkey");
		System.out.println(password);
		
		User user = dao.getUser(email, password);
				
		if(user != null) {
			if(password.equals(user.getPassword())) {
				request.setAttribute("name", user.getUserName());
				request.setAttribute("id", ""+user.getUserId());
				request.setAttribute("phonenumber", ""+user.getPhoneNumber());
				chain.doFilter(request, response);	
			}
			else {
				out.print("<html><p>Wrong email/password. Try Again....</p></html>");
				RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
				dispatch.include(request, response);	
			}
		}
		else {
			out.print("<html><p>Wrong email. Try Again....</p></html>");
			RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.include(request, response);	
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
}
