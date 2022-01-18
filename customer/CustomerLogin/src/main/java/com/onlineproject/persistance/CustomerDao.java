package com.onlineproject.persistance;

import java.sql.SQLException;
import java.util.List;

import com.onlineproject.bean.Cart;
import com.onlineproject.bean.CartList;
import com.onlineproject.bean.Customer;
import com.onlineproject.bean.Product;

public interface CustomerDao
{
int signUp(Customer customer)throws ClassNotFoundException,SQLException;
Customer logIn(String name, String password)throws ClassNotFoundException,SQLException;
int addToCart(Product product)throws ClassNotFoundException,SQLException;
//Product getProductById(Long id)throws ClassNotFoundException,SQLException;
List<Cart> getCart()throws ClassNotFoundException,SQLException;
}