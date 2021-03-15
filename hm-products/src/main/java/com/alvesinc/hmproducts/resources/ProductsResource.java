package com.alvesinc.hmproducts.resources;

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

import com.alvesinc.hmproducts.dto.ProductDTO;
import com.alvesinc.hmproducts.entities.Product;
import com.alvesinc.hmproducts.mapper.ProductModelMapper;
import com.alvesinc.hmproducts.service.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Products")
@RestController
@RequestMapping(value = "/products")
public class ProductsResource {

	@Autowired
	private IProductService service;
	
	@Autowired
	private ProductModelMapper mapper;

	@ApiOperation("Create Products")
	@PostMapping("/create")
	public ResponseEntity<Product> create(@Valid @RequestBody ProductDTO productDTO) {
		Product product = mapper.toEntityObject(productDTO);
		Product obj = service.create(product);
		return ResponseEntity.ok(obj);
		
	}
	
	@ApiOperation("Find Product by id")
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@ApiOperation("Find All Products")
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@ApiOperation("Updade Products")
	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody ProductDTO newProduct) {
		Product product = mapper.toEntityObject(newProduct);
		Product obj = service.update(product);
		return ResponseEntity.ok(obj);

	}
	
	@ApiOperation("Delete Products by id")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Search products with Pagination")
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
