package com.galosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galosoft.models.Product;
import com.galosoft.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProductList() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.getOne(id);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	public void editProduct(Product product) {
		productRepository.save(product);
	}

}
