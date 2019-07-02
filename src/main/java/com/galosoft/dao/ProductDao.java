package com.galosoft.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.galosoft.models.Product;

public class ProductDao {
	
	private List<Product> productList;
	
	public List<Product> getProductList(){
		
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		
		product1.setProductId(1);
		product1.setProductName("Microfono");
		product1.setProductDescription("Microfono alambrico");
		product1.setProductCondition("nuevo");
		product1.setProductStatus("activo");
		product1.setProductManufacturer("Fussion");
		product1.setProductPrice(200.00D);
		product1.setProductUnits(2);
		
		product2.setProductId(2);
		product2.setProductName("Pila recargable");
		product2.setProductDescription("Pila recargable");
		product2.setProductCondition("nuevo");
		product2.setProductStatus("activo");
		product2.setProductManufacturer("Fussion");
		product2.setProductPrice(200.00D);
		product2.setProductUnits(2);
		
		product3.setProductId(3);
		product3.setProductName("Adaptador usb");
		product3.setProductDescription("Adaptador usb");
		product3.setProductCondition("nuevo");
		product3.setProductStatus("activo");
		product3.setProductManufacturer("Fussion");
		product3.setProductPrice(200.00D);
		product3.setProductUnits(2);
		
		productList = new ArrayList<Product>();
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		return productList;
 	}

	public Product getProductById(int productId) throws IOException{
		for(Product product: getProductList()) {
			if(product.getProductId() == productId) {
				return product;
			}
		}
		throw new IOException("Product not found");
	}

}
