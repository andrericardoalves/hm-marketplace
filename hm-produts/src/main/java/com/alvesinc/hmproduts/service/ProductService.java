package com.alvesinc.hmproduts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesinc.hmproduts.entities.Product;
import com.alvesinc.hmproduts.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product create(Product product) {
		return repository.save(product);
		
	}
	
	public Product findById(Long id){
	
	Optional<Product> product = repository.findById(id);
	 
	if(product.isPresent()){
		 return product.get();
	}
	
		return null;
	}
	
	public void delete(Long id){
		repository.deleteById(id);
	}
	
	public Product update(Product obj) {
		Product newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
	}
	
	public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	
}
