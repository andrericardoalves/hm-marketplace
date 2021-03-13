package com.alvesinc.hmproduts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvesinc.hmproduts.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
