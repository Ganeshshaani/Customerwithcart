package com.onlineproject.service;

import java.sql.SQLException;
import java.util.List;

import com.onlineproject.bean.Cart;
import com.onlineproject.bean.CartList;
import com.onlineproject.bean.Customer;
import com.onlineproject.bean.Product;
import com.onlineproject.bean.ProductList;

public interface CustomerService {
	public boolean signingUp(Customer customer)throws ClassNotFoundException,SQLException;
	public boolean logingIn(String name, String Password)throws ClassNotFoundException,SQLException;
	public ProductList viewProduct()throws ClassNotFoundException,SQLException;
	int addProduct(String id)throws ClassNotFoundException,SQLException;
	public List<Cart> getAllCart()throws ClassNotFoundException,SQLException;
}
