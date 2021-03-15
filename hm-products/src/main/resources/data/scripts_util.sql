select *
       from
   product p
  inner join product_category pc on  pc.product_id = p.id 
  inner join category c on c.id = pc.category_id
  left join news n on n.category_id = c.id 
  left join sale s on s.product_id = p.id
  order by c.name asc;
  
 -- X = Média de avaliação do produto nos últimos 12 meses
   select p.id, p.name -- , CAST(avg(s.rating) AS DECIMAL(10,2)) 
      from 
      product p
      left join sale s on p.id = s.product_id
      where 1 = 1 
      and coalesce(s.created_at, date_sub(curdate(), interval 1 day)) > date_sub(curdate(), interval 1 year)
      group by p.id, p.name;

 -- Y = Quantidade de vendas/dias que o produto existe
  select 
   p.id,
   p.name,
   cast(coalesce(
     cast(count(s.product_id) as decimal(10,2)) /
     cast(datediff(curdate(), p.created_at) as decimal(10,2)), 0) as decimal(10,2))
   from product p 
   left join sale s on s.product_id = p.id
   where 1 = 1 
   group by p.id;
   
  -- Z = Quantidade de notícias da categoria do produto no dia corrente
    select p.id, p.name, date(n.published_at), cast(coalesce(n.total_results, 0) as decimal(10,2))
       from 
       product p 
       inner join product_category pc on pc.product_id = p.id 
       inner join category c on c.id = pc.category_id
       left join news n on n.category_id = c.id 
       where 1 = 1 
       and coalesce(date(n.published_at), date(curdate())) = date(curdate())
   