package com.alvesinc.hmproducts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.alvesinc.hmproducts.dto.ProductsRankingResponse;
import com.alvesinc.hmproducts.entities.News;

public interface INewsService {
	
	public List<News> obtainNewsByCategory();
	public ProductsRankingResponse obtainNewsByOrderByRanking( String name, LocalDate currentDate, Pageable pageable);
}
