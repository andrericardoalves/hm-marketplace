package com.alvesinc.hmproduts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.alvesinc.hmproduts.entities.Product;

@Service
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
