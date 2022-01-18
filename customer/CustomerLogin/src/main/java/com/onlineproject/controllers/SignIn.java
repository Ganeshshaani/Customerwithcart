package com.onlineproject.controllers;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineproject.bean.Customer;
import com.onlineproject.service.CustomerService;
import com.onlineproject.service.CustomerServiceImpl;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignIn() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
		CustomerService customers=new CustomerServiceImpl();
		
		Customer customer=new Customer(name,password);
		session.setAttribute("customer", customer);
		session.setAttribute("name", name);

		try {
			if(customers.logingIn(name, password)) {
				response.sendRedirect("./main.jsp");
			}
			else {
				response.sendRedirect("./logininfailed.jsp");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
