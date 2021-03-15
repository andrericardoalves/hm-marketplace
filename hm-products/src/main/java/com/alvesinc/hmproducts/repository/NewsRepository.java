package com.alvesinc.hmproducts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alvesinc.hmproducts.dto.ProductsRanking;
import com.alvesinc.hmproducts.entities.News;

public interface NewsRepository extends JpaRepository<News, Long>{

	@Query(
	  value= "select p.id , "
	  		+ " p.name,"
	  		+ " p.created_at , p.description,"
	  		+ " coalesce("
	  		+ "  cast(avg(coalesce(s.rating, 0)) as decimal(10,2)) + "
	  		+ " cast(coalesce("
	  		+ " cast(count(s.product_id) as decimal(10,2)) /"
	  		+ " cast(datediff(curdate(), p.created_at) as decimal(10,2)), 0) as decimal(10,2))  + "
	  		+ " cast(coalesce(n.total_results, 0) as decimal(10,2)) , 0) score"
	  		+ "  from"
	  		+ "  product p"
	  		+ " inner join product_category pc on  pc.product_id = p.id "
	  		+ " inner join category c on c.id = pc.category_id"
	  		+ " left join news n on n.category_id = c.id"
	  		+ " left join sale s on s.product_id = p.id"
	  		+ " where 1 = 1"
	  		+ " and coalesce(date(n.published_at), date(curdate())) = date(curdate())"
	  		+ " and coalesce(s.created_at, date_sub(curdate(), interval 1 day)) > date_sub(curdate(), interval 1 year)"
	  		+ " and ( p.name = :name or :name is null) "
	  		+ " and ( date(n.published_at) = date(:currentDate) or :currentDate is null) "
	  		+ " group by"
	  		+ "  p.id ,"
	  		+ " p.name,"
	  		+ " p.description,"
	  		+ " created_at,"
	  		+ "  n.total_results,"
	  		+ " c.name "
	  		+ " order by score desc, p.name, c.name asc",
	  nativeQuery = true	)
	public List<ProductsRanking> obtainNewsByOrderByRanking(String name, LocalDate currentDate, Pageable  pageable);
	
	
}
