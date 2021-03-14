package com.alvesinc.hmproducts.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsApiDTO {
	
	private String status;
    private Long totalResults;
    private List<ArticlesNewsApiDTO> articles;
    
}
