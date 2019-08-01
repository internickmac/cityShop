package com.galosoft.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable{

	private static final long serialVersionUID = 8086167490027136712L;
	
	@Id
	@GeneratedValue
	private int customerOrderId;
	
	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

}
