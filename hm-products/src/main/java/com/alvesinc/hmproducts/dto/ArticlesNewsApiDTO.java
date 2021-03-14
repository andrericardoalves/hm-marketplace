package com.alvesinc.hmproducts.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticlesNewsApiDTO {

	private SourceNewsApiDTO source;
	private String author; 
    private String title; 
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;
	
}
