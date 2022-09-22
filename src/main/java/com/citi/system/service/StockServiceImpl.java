package com.citi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.system.dto.StockDTO;
import com.citi.system.repository.StockRepository;


@Component("StockService")
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRep;
	
	@Override
	public List<StockDTO> getSavedStocks(String user_name) {
		List<StockDTO> savedStocks= stockRep.getSavedStocks(user_name);
		return savedStocks;
	}

	@Override
	public boolean deleteSavedStock(String stockSymbol, String username) {
		boolean isDeleted= stockRep.deleteSavedStock(stockSymbol, username);
		return isDeleted;
	}

	@Override
	public boolean addToSavedStocks(StockDTO stock) {
		boolean isAdded= stockRep.addToSavedStocks(stock);
		return isAdded;
	}

}
