package com.alvesinc.hmproducts.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsApiDTO {
	
	private String status;
    private Long totalResults;
    private List<ArticlesNewsApiDTO> articles;
    
}
