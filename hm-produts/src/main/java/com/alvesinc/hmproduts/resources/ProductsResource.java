package com.alvesinc.hmproduts.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesinc.hmproduts.entities.Product;
import com.alvesinc.hmproduts.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductsResource {

	@Autowired
	private ProductService service;

	@PostMapping("/create")
	public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
		Product obj = service.create(product);
		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product newProduct) {
		Product obj = service.update(newProduct);
		return ResponseEntity.ok(obj);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping(value = "/findPage")
	public ResponseEntity<Page<Product>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="instante") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Product> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}

}
