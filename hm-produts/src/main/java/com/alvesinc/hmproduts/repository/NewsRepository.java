package com.alvesinc.hmproduts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesinc.hmproduts.entities.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}
