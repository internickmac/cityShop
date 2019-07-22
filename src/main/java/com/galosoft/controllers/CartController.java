package com.galosoft.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.galosoft.models.Cart;
import com.galosoft.models.CartItem;
import com.galosoft.models.Product;
import com.galosoft.repos.CartRepository;
import com.galosoft.repos.ProductRepository;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
		return cartRepository.read(cartId);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
		cartRepository.update(cartId, cart);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartRepository.delete(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		
		Cart cart = cartRepository.read(sessionId);
		
		if(cart == null) {
			cart = cartRepository.create(new Cart(sessionId));
		}
		
		Product product = productRepository.getOne(Integer.parseInt(productId));
		
		if(product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.addCartItem(new CartItem(product));
		
		cartRepository.update(sessionId, cart);
	}
	
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		
		Cart cart = cartRepository.read(sessionId);
		
		if(cart == null) {
			cart = cartRepository.create(new Cart(sessionId));
		}
		
		Product product = productRepository.getOne(Integer.parseInt(productId));
		
		if(product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.removeCartItem(new CartItem(product));
		
		cartRepository.update(sessionId, cart);
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your playload")
	public void handleClientErrors(Exception e) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "iNTERNAL sERVER eRROR")
    public void handleServerErrors(Exception e) {}

}
