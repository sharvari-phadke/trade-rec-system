package com.citi.system.service;

import java.util.List;

import com.citi.system.dto.StockDTO;

public interface StockService {
	
	public List<StockDTO> getSavedStocks(String user_name);
	public boolean deleteSavedStock(String stockSymbol, String username);
	public boolean addToSavedStocks(StockDTO stock);

}
