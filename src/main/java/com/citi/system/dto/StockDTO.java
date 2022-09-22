package com.citi.system.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
	private String symbol;
	private BigDecimal currPrice;	
	private BigDecimal close2WeeksAgo;	
	private Double changePercent;
	private int quantitySaved;
	private String username;

}
