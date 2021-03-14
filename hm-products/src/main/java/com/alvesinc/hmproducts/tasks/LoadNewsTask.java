package com.alvesinc.hmproducts.tasks;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alvesinc.hmproducts.service.INewsService;


@Component
@EnableScheduling
public class LoadNewsTask {

	 @Autowired 
	 private INewsService service;
	 
	 @Autowired
	 private Logger logger;
	 
	 
	 @Scheduled(cron="0 0 0,6,12,18 * * *")
	  private void loadNews() {
		 this.service.obtainNewsByCategory();
		 logger.info("Execution task load news at " + LocalDateTime.now());
	 }
}
