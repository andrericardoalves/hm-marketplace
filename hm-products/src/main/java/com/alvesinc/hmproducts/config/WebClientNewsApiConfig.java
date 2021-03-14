package com.alvesinc.hmproducts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
;

@Configuration
public class WebClientNewsApiConfig {

 @Value("${news-api.url.base}")
 private String NEWS_API_URL_BASE;
	
	@Bean
    public WebClient  getWebClientNewsApi() {
       
		WebClient webClient = WebClient.builder()
		        .baseUrl(NEWS_API_URL_BASE)
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, 
		        		       MediaType.APPLICATION_JSON_VALUE)
		        .build();
		
		return webClient; 
    }
}
