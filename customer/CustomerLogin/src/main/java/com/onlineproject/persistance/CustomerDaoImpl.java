package com.onlineproject.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineproject.bean.Cart;
import com.onlineproject.bean.CartList;
import com.onlineproject.bean.Customer;
import com.onlineproject.bean.Product;
import com.onlineproject.helper.OracleConnection;

public class CustomerDaoImpl implements CustomerDao {

	public int signUp(Customer customer) throws ClassNotFoundException,SQLException
	{

		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO CUSTOMER(CUSTOMERNAME,CUSTOMEREMAIL,CUSTOMERPASSWORD) VALUES(?,?,?)");
		
		
		preparedStatement.setString(1, customer.getCustomerName());
		preparedStatement.setString(2, customer.getCustomerEmail());
		preparedStatement.setString(3, customer.getCustomerPassword());
		
		int rows=preparedStatement.executeUpdate();
		connection.close();
		return rows;
	}
	
	
	
	public Customer logIn(String name, String password) throws ClassNotFoundException,SQLException
	{
		Connection connection = OracleConnection.getConnection();
	Customer customer=null;
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=? and CUSTOMERPASSWORD=? ");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			String customerName = resultSet.getString("CUSTOMERNAME");
			String customerEmail= resultSet.getString("CUSTOMEREMAIL");
			String customerPassword = resultSet.getString("CUSTOMERPASSWORD");
			
		 customer=new Customer(customerName,customerEmail,customerPassword);
		
		}
      connection.close();
		return customer;
	}



	@Override
	public int addToCart(Product product) throws ClassNotFoundException, SQLException {
	
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO cart(ID,CODE,NAME,DESCRIPTION,PRICE) VALUES(?,?,?,?,?)");
		preparedStatement.setLong(1, product.getId());
		preparedStatement.setString(2, product.getCode());
		preparedStatement.setString(3, product.getName());
		preparedStatement.setString(4, product.getDescription());
		preparedStatement.setDouble(5, product.getPrice());
		
		int rows=preparedStatement.executeUpdate();
		connection.close();
		return rows;
	
	}



//	@Override
//	public Product getProductById(Long id) throws ClassNotFoundException, SQLException {
//		Connection connection = OracleConnection.getConnection();
//		Product prod=null;
//		
//		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE id=?");
//	preparedStatement.setLong(1, id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		
//		 if(resultSet.next()) {
//			long pid = resultSet.getLong("ID");
//			String code = resultSet.getString("CODE");
//			String name = resultSet.getString("NAME");
//			String description = resultSet.getString("DESCRIPTION");
//			double price = resultSet.getDouble("PRICE");
//			
//		 prod=new Product(pid, code, name, description, price);
//		}
//		connection.close();
//		return prod;
//	
//	}
//
//
//
	@Override
	public List<Cart> getCart() throws ClassNotFoundException, SQLException {
	
List<Cart> productList = new ArrayList<Cart>();

		
		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cart");
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("i am persistance");
		
	while (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code= resultSet.getString("code");
			String name= resultSet.getString("NAME");
		String description = resultSet.getString("description");
			double  price= resultSet.getDouble("price");
			
		Cart prod=new Cart(id, code, name, description, price);
		productList.add(prod);
		}

		connection.close();

		return productList;
	
	}


}
