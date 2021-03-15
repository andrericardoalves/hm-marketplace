package com.alvesinc.hmproducts.dto;

import java.time.LocalDateTime;

public interface ProductsRanking {
	
	Long getId();
	String getName(); 
	String getDescription();
	LocalDateTime getCreatedAt();
	Double getScore();
}
