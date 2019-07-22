package com.galosoft.repos;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.galosoft.models.Cart;

@Service
public class CartRepositoryImpl implements CartRepository {
	
	private Map<String, Cart> listOfCarts;
	
	public CartRepositoryImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Can not create a dart with id: (%)", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Can not create a dart with id: (%)", cart.getCartId()));
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not create a dart with id: (%)", cartId));
		}
		listOfCarts.remove(cartId);
	}

}
