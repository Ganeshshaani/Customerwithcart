package com.onlineproject.controllers;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineproject.bean.ProductList;
import com.onlineproject.service.CustomerService;
import com.onlineproject.service.CustomerServiceImpl;

/**
 * Servlet implementation class ViewProduct
 */
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CustomerService cusser=new CustomerServiceImpl();
		ProductList products=null;
		try {
		products=cusser.viewProduct();
		System.out.println(products);
		}
		 catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("productlist", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./viewproduct.jsp");
		dispatcher.forward(request, response);
	
	}
}