package com.onlineproject.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineproject.service.CustomerService;
import com.onlineproject.service.CustomerServiceImpl;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
	String  id=request.getParameter("productid");
	//long id=Long.parseLong(id1);
		CustomerService service=new CustomerServiceImpl();
		int rows=0;
	try {
		 rows=service.addProduct(id);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(rows>0)
		response.sendRedirect("./addcart.jsp");
	else
		response.sendRedirect("./nocart.jsp");
	}
}
