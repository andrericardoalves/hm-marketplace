package com.alvesinc.hmproduts.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Category{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	@NotBlank
	private String name;
}
