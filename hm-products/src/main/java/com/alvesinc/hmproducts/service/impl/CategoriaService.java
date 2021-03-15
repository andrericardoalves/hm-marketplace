package com.alvesinc.hmproducts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesinc.hmproducts.entities.Category;
import com.alvesinc.hmproducts.repository.CategoryRepository;
import com.alvesinc.hmproducts.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	private CategoryRepository repositoy;
	
	public List<Category> findAll(){
		return repositoy.findAll();
	}
}
