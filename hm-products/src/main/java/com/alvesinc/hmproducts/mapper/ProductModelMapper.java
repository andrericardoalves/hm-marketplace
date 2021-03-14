package com.alvesinc.hmproducts.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.alvesinc.hmproducts.dto.ProductDTO;
import com.alvesinc.hmproducts.entities.Category;
import com.alvesinc.hmproducts.entities.Product;

@Component
public class ProductModelMapper {

	public ProductDTO toDto(Product product) {
		
		ProductDTO dto =   ProductDTO.builder()
					      .id(product.getId())
					      .name(product.getName())
					      .description(product.getDescription())
					      .createdAt(product.getCreatedAt())
					      .categorias(product.getCategorias().stream().map(c -> c.getId()).collect(Collectors.toList()))
					      .build();
		return dto;
	}

	

	public Product toEntityObject(ProductDTO productDTO) {
		
		Product obj =  Product.builder()
			      .id(productDTO.getId())
			      .name(productDTO.getName())
			      .description(productDTO.getDescription())
			      .createdAt(productDTO.getCreatedAt())
			      .categorias(productDTO.getCategorias().stream().map(c -> Category.builder().id(c).build()).collect(Collectors.toList()))
			      .build();
		return obj;
	}

	
}
