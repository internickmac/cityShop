package com.galosoft.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galosoft.models.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
