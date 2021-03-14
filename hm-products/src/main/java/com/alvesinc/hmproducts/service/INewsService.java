package com.alvesinc.hmproducts.service;

import java.util.List;

import com.alvesinc.hmproducts.entities.News;

public interface INewsService {
	
	public List<News> obtainNewsByCategory();
}
