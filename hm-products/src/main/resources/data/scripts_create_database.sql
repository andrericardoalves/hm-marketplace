create database hmproducts;

use hmproducts;

create table product(
  id int primary key auto_increment,
  name varchar(255) not null,
  description varchar(2048) not null,
  created_at timestamp
);

create table category(
  id int primary key auto_increment,
  name varchar(128) not null
);

alter table product add column category_id int, add constraint fk_product_category foreign key (category_id) references category(id);

create table sale(
  id          int primary key auto_increment,
  rating      real not null,
  created_at  timestamp,
  product_id  int not null,
  constraint fk_sale_product foreign key (product_id) references product (id)
)

create table news(
  id            int primary key auto_increment,
  published_at  timestamp,
  category_id   int not null,
  total_results varchar(512),
  constraint fk_news_category foreign key (category_id) references category (id)
)

CREATE TABLE product_category (
  product_id bigint(20) NOT NULL,
  category_id bigint(20) NOT NULL,
  KEY fk_category_id (category_id),
  KEY fk_product_id (product_id)
);