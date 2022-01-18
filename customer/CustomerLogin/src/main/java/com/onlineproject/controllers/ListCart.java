package com.onlineproject.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.onlineproject.bean.Cart;
import com.onlineproject.bean.CartList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineproject.bean.Product;
import com.onlineproject.service.CustomerService;
import com.onlineproject.service.CustomerServiceImpl;


public class ListCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CustomerService service=new CustomerServiceImpl();
List<Cart> cartlist=null;

		try {
	 		cartlist=service.getAllCart();
	 		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 session.setAttribute("cartlist",cartlist);
			RequestDispatcher dispatcher=request.getRequestDispatcher("./showcart.jsp");
			dispatcher.forward(request, response);
	}

	
}
