select p.id ,
	   p.name,
       p.description,
       p.created_at,
      coalesce(
       cast(avg(coalesce(s.rating, 0)) as decimal(10,2)) +
       cast(coalesce(
       cast(count(s.product_id) as decimal(10,2)) /
       cast(datediff(curdate(), p.created_at) as decimal(10,2)), 0) as decimal(10,2))  +
       cast(coalesce(n.total_results, 0) as decimal(10,2)) , 0) score
     from
      product p
  	  inner join product_category pc on  pc.product_id = p.id 
	  inner join category c on c.id = pc.category_id
	  left join news n on n.category_id = c.id
	  left join sale s on s.product_id = p.id
	  where 1 = 1
	  
     and coalesce(date(n.published_at), date(curdate())) = date(curdate())
     and coalesce(s.created_at, date_sub(curdate(), interval 1 day)) > date_sub(curdate(), interval 1 year)
     
     group by
	   p.id ,
	   p.name,
       p.description,
       created_at,
       n.total_results,
       c.name 
  order by score desc, p.name, c.name asc