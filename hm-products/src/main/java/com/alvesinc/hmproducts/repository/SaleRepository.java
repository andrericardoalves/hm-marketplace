package com.alvesinc.hmproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvesinc.hmproducts.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
