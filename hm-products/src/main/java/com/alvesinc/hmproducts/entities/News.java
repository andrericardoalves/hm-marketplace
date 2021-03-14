package com.alvesinc.hmproducts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class News {

	  @Id
	  @EqualsAndHashCode.Include
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  private String name;

	  @ManyToOne 
	  private Category category;
}
