package com.alvesinc.hmproducts.dto;

import java.time.LocalDateTime;
import java.util.List;

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
public class ProductsRankingResponse {

	private LocalDateTime dataAtual;
	private String termoPesquisado;
	private List<ProductsRanking> products;
	
}
