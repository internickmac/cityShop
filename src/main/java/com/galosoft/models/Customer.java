package com.galosoft.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 3395357715819831450L;
	
	@Id
	@GeneratedValue
	private int customerId;
	
	@NotEmpty(message = "El nombre no puede quedar vacio")
	private String customerName;
	
	@NotEmpty(message = "El email no puede quedar vacio")
	private String customerEmail;
	
	private String customerPhone;

	@NotEmpty(message = "El username no puede quedar vacio")
	private String username;
	
	@NotEmpty(message = "El password no puede quedar vacio")
	private String password;
	
	private boolean anabled;
	
	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;
	
	
	@OneToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAnabled() {
		return anabled;
	}


	public void setAnabled(boolean anabled) {
		this.anabled = anabled;
	}


	public BillingAddress getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}


	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
