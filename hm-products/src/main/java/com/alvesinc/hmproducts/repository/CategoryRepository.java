package com.alvesinc.hmproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvesinc.hmproducts.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
