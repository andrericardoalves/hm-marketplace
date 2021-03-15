package com.alvesinc.hmproducts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesinc.hmproducts.entities.Product;
import com.alvesinc.hmproducts.expection.BusinessException;
import com.alvesinc.hmproducts.expection.DataIntegrityException;
import com.alvesinc.hmproducts.expection.ObjectNotFoundException;
import com.alvesinc.hmproducts.repository.ProductRepository;
import com.alvesinc.hmproducts.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repository;

	public Product create(Product product) {
	     
		 if (verifyIfProductExist(product.getName())) {
		      throw new BusinessException("There is already a product with the name" + product.getName());
		    }
		return repository.save(product);

	}
	
	public boolean verifyIfProductExist(String name){
	  Product productPersited = this.findProductByName(name);
	  return	productPersited != null && productPersited.getName().equalsIgnoreCase(name) ? true : false; 
	}
	
	public Product findProductByName(String name) {
		return repository.findProductByName(name);
	}

	public Product findById(Long id) {

		Optional<Product> product = repository.findById(id);
		if (product.isEmpty()) {
			throw new ObjectNotFoundException(
					"Object not found! Id: " + id + ", Tyoe: " + Product.class.getName());
		}
		
		return product.get();
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are related orders");
		}
	}

	public Product update(Product obj) {
		Product newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
		newObj.setCategories(obj.getCategories());
	}

	public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

}
