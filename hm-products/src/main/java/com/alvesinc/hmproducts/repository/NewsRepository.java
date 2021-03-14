package com.alvesinc.hmproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesinc.hmproducts.entities.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}
