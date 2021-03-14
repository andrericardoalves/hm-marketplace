package com.alvesinc.hmproducts.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvesinc.hmproducts.entities.News;
import com.alvesinc.hmproducts.service.INewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsResource {
	
	@Autowired
	private INewsService service;

	
	@GetMapping(value="obtainNewsByCategory")
	public ResponseEntity<List<News>>  obtainNewsByCategory () {
		List<News> news = service.obtainNewsByCategory();
		return ResponseEntity.ok(news);
	}
	
}
