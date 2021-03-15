package com.alvesinc.hmproducts.service;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.alvesinc.hmproducts.entities.Category;
import com.alvesinc.hmproducts.entities.Product;
import com.alvesinc.hmproducts.expection.ObjectNotFoundException;
import com.alvesinc.hmproducts.repository.CategoryRepository;
import com.alvesinc.hmproducts.repository.ProductRepository;
import com.alvesinc.hmproducts.service.impl.ProductService;

@SpringBootTest
class ProductServiceTest {

	private static final Long ENTITY_PERSISTED_ID = 1L;
	private static final Long ENTITY_ID_NOT_FOUND = 9999L;
	
	
	@Autowired 
	private ProductService productService;

	@MockBean 
	private ProductRepository mockedProductRepository;
 
	@MockBean 
	private CategoryRepository mockedCategoryRepository;
    
	private static Category mockCategory;
	
	private static Product mockProduct;

	  @BeforeAll
	  static void setup() {
		  mockCategory = Category.builder()
	    		.id(ENTITY_PERSISTED_ID)
	    		.name("Game").build();
	    
		  mockProduct = Product.builder()
	    		 .id(ENTITY_PERSISTED_ID) 
				 .name("Street Fighter")
	    		 .description("Street Fighter II was the first one-on-one fighting game")
	    		 .createdAt(LocalDateTime.now())
	    	     .categories(Arrays.asList(mockCategory))
	    		 .build();
	   
	  }
	  
	  @Test
	  @DisplayName("Should to save products with success")
	  void shouldToSaveProductWithSucess() {
		  
		  doReturn(mockProduct).when(mockedProductRepository).save(mockProduct);
		 
		  doReturn(Optional.of(mockCategory)).when(mockedCategoryRepository)
		        .findById(mockCategory.getId());

		    Product returnedProduct = productService.create(mockProduct);

		    Assertions.assertNotNull(returnedProduct);
		    Assertions.assertEquals(ENTITY_PERSISTED_ID, returnedProduct.getId());
	  }
	  
	  @Test
	  @DisplayName("Should to find Product by ID ")
	  void shouldToFindProductById() {
	    
	  doReturn(Optional.of(mockProduct)).when(mockedProductRepository)
	        .findById(ENTITY_PERSISTED_ID);

	    Product returnedProduct = productService.findById(ENTITY_PERSISTED_ID);
	    Assertions.assertNotNull(returnedProduct);
	    Assertions.assertEquals(returnedProduct.getId(), ENTITY_PERSISTED_ID);
	  }
	  
	 
	  @Test
	  @DisplayName("Should be able throws exception when not found a product by id")
	  void shouldToReturnExceptionWhenNotProducNotExiste() {
	    doReturn(Optional.empty()).when(mockedProductRepository).findById(ENTITY_ID_NOT_FOUND);

	    ObjectNotFoundException ex =
	        Assertions.assertThrows(
	        		ObjectNotFoundException.class,
	            () -> {
	              productService.findById(ENTITY_ID_NOT_FOUND);
	            });

	    Assertions.assertEquals(
	        ex.getMessage(), "Object not found! Id: " + ENTITY_ID_NOT_FOUND + ", Tyoe: " + Product.class.getName());
	  }
	  
	 
}
