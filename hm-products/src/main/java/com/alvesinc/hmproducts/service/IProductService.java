package com.alvesinc.hmproducts.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.alvesinc.hmproducts.entities.Product;


public interface IProductService {

	public Product create(Product product) ;
	public Product findById(Long id);
	public void delete(Long id);
	public Product update(Product obj) ;
	public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
	public List<Product> findAll();
	
	
}
