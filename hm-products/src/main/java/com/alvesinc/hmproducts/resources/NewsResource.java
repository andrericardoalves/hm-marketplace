package com.alvesinc.hmproducts.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesinc.hmproducts.dto.ProductsRankingResponse;
import com.alvesinc.hmproducts.entities.News;
import com.alvesinc.hmproducts.service.INewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "News")
@RestController
@RequestMapping(value = "/news")
public class NewsResource {
	
	@Autowired
	private INewsService service;

	@ApiOperation("Obtain News of News API avalible in https://newsapi.org/docs/get-started ")
	@GetMapping(value="obtainNewsByCategory")
	public ResponseEntity<List<News>>  obtainNewsByCategory () {
		List<News> news = service.obtainNewsByCategory();
		return ResponseEntity.ok(news);
	}
	
	@ApiOperation("Search for products ordered by ranking by name and category ")
	@GetMapping(value = "/obtainNewsByOrderByRanking")
	public ResponseEntity<ProductsRankingResponse> obtainNewsByOrderByRanking(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="200") Integer linesPerPage, 
			@RequestParam(value="name", required = false) String name,
			@RequestParam(value="currentDate", required =  false) LocalDate currentDate) {
		
		PageRequest pageable = PageRequest.of(page, linesPerPage);
		ProductsRankingResponse news = service.obtainNewsByOrderByRanking( name, currentDate, pageable);
		return ResponseEntity.ok(news);
		
	}
	
}
