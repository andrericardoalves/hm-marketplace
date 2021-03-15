package com.alvesinc.hmproducts.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Audited
@AuditTable(value = "sale_audit")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sale {

	  @Id
	  @EqualsAndHashCode.Include
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  private Double rating;

	  @CreationTimestamp 
	  private LocalDateTime createdAt;

	  @ManyToOne
	  @JoinColumn(name = "product_id")
	  private Product product;
}
