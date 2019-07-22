package com.galosoft.repos;

import com.galosoft.models.Cart;

public interface CartRepository {
	
	Cart create(Cart cart); 
	Cart read(String cartId);
	void update(String cartId, Cart cart);
    void delete(String cartId);
}
