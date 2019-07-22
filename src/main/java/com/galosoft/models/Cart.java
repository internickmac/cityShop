package com.galosoft.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private String cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotal;
    
    public Cart() {
    	cartItems = new HashMap<String, CartItem>();
    	grandTotal = 0;
    }
    
    public Cart(String cartId) {
    	this();
    	this.cartId = cartId;
    }

	
	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public void addCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		
		if(cartItems.containsKey(String.valueOf(productId))) {
			CartItem existingCartItem = cartItems.get(String.valueOf(productId));
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(String.valueOf(productId), item);
		} else {
			cartItems.put(String.valueOf(productId), item);
		}
		
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item) {
		int productId = item.getProduct().getProductId();
		cartItems.remove(String.valueOf(productId));
		updateGrandTotal();
	}

	private void updateGrandTotal() {
		grandTotal = 0;
		
		for(CartItem item: cartItems.values()) {
			grandTotal += item.getTotalPrice();
		}
	}
   
}










