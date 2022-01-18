package com.onlineproject.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineproject.bean.Customer;
import com.onlineproject.service.CustomerService;
import com.onlineproject.service.CustomerServiceImpl;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		CustomerService customer=new CustomerServiceImpl();
		
		Customer cust=new Customer(name,email,password);

	String message=null;
		try {
			if(customer.signingUp(cust)) {
			message="Signup Successfull.. please login and Continue Shopping";
		}
		else {
			message="Signing up failed....! , please try again";
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		session.setAttribute("message", message);
		RequestDispatcher dispatcher=request.getRequestDispatcher("./signupsuccessfull.jsp");
		dispatcher.forward(request, response);
	
	}

}