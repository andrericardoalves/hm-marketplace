package com.alvesinc.hmproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.alvesinc.hmproducts.entities.Product;

@Service
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	public Product findProductByName(String name);

}
