package com.alvesinc.hmproducts.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.alvesinc.hmproducts.dto.ArticlesNewsApiDTO;
import com.alvesinc.hmproducts.dto.NewsApiDTO;
import com.alvesinc.hmproducts.dto.ProductsRanking;
import com.alvesinc.hmproducts.dto.ProductsRankingResponse;
import com.alvesinc.hmproducts.entities.Category;
import com.alvesinc.hmproducts.entities.News;
import com.alvesinc.hmproducts.repository.NewsRepository;
import com.alvesinc.hmproducts.service.ICategoriaService;
import com.alvesinc.hmproducts.service.INewsService;
import com.alvesinc.hmproducts.util.LocalDateTimeUtil;

import reactor.core.publisher.Mono;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsRepository repository;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	 @Value("${news-api.apiKey}")
	 private String NEWS_API_APIKEY;
	 
	 
	 
	 public List<News> obtainNewsByCategory() {
		 
	   List<News> newsToSave = new ArrayList<News>();	 
	   List <Category> categories = categoriaService.findAll();
	   
	   for (Category category : categories) {	
			NewsApiDTO newsDto = this.searchFromNewsApi(category);
			
			if(newsDto.getTotalResults() > 0) {
				NewsApiDTO newsToday = this.filterNewsByDate(newsDto);
				if(newsToday.getTotalResults() > 0) {
					News objNews = News.builder().publishedAt(LocalDateTime.now()).totalResults(newsToday.getTotalResults()).category(category).build();
					newsToSave.add(objNews);
				}
			}
		   
	   }
	   
	  repository.saveAll(newsToSave); 
	   
	  return newsToSave;
	 }



	private NewsApiDTO searchFromNewsApi(Category category) {
		Mono<NewsApiDTO> returnCategories =  webClient.get().uri(builder ->
		   builder
		   .path("/top-headlines")
		   .queryParam("category", category.getName())
		   .queryParam("apiKey", NEWS_API_APIKEY)
		   .queryParam("country", "us")
		   .build())
		   .retrieve()
		   .bodyToMono(NewsApiDTO.class);
		NewsApiDTO retornNewsApi = returnCategories.block();
		return retornNewsApi;
	}
	
	private NewsApiDTO filterNewsByDate(NewsApiDTO newsDto){
		
		LocalDateTime today = LocalDateTime.now();
		List <ArticlesNewsApiDTO> articlesToday = newsDto.getArticles().stream()
				  .filter( c ->  LocalDateTimeUtil.isSameDay(c.getPublishedAt(), today) ).collect(Collectors.toList());
		
		NewsApiDTO newsApiDTOToday = NewsApiDTO.builder().articles(articlesToday).totalResults(Long.valueOf(articlesToday.size())).build();
		
		return newsApiDTOToday;
	}
	
	public ProductsRankingResponse obtainNewsByOrderByRanking( String name, LocalDate currentDate, Pageable pageable){
	
	 List<ProductsRanking> news = repository.obtainNewsByOrderByRanking( name,  currentDate,  pageable);
	 ProductsRankingResponse obj =  ProductsRankingResponse.builder()
			 .dataAtual(LocalDateTime.now())
			 .termoPesquisado(name)
			 .products(news).build();
	 
		return obj;
	}
	
}
