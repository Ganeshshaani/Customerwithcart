package com.onlineproject.bean;

import java.util.List;

public class ProductList {
	@Override
	public String toString() {
		return "ProductList [products=" + products + "]";
	}
	private List<Product> products;
	public ProductList() {
		
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
