package com.alvesinc.hmproduts.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	@EqualsAndHashCode.Include
	private Long id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "Description is mandatory")
	private String description;
	@CreationTimestamp
	private LocalDateTime creationDate;
	@UpdateTimestamp
	private LocalDateTime modifyDate;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "product_category",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categorias = new ArrayList<>();
	

}