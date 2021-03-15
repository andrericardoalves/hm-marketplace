package com.alvesinc.hmproducts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesinc.hmproducts.entities.Sale;
import com.alvesinc.hmproducts.repository.SaleRepository;
import com.alvesinc.hmproducts.service.ISaleService;

@Service
public class SaleService implements ISaleService {

	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findAll(){
		return repository.findAll();
	}
}
