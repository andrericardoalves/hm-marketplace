package com.alvesinc.hmproducts.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Audited
@AuditTable(value = "news_audit")
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

	  @ManyToOne 
	  private Category category;
	  
	  private LocalDateTime publishedAt;
	  
	  private Long totalResults;
}
