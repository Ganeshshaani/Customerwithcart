package com.onlineproject.bean;

import java.util.List;

public class CartList
{
	private List<Cart> cartlist;
public CartList()
{
	
}
	public List<Cart> getCartlist() {
	return cartlist;
}
public void setCartlist(List<Cart> cartlist) {
	this.cartlist = cartlist;
}
	@Override
	public String toString() {
		return "CartList [cartlist=" + cartlist + "]";
	}
}
