package com.galosoft.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.galosoft.models.Product;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
