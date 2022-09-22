package com.citi.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.system.dto.StockDTO;
import com.citi.system.entities.CapWiseStockSymbols;
import com.citi.system.service.StockRecService;
import com.citi.system.service.StockService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api/stocks", method = {RequestMethod.GET, RequestMethod.POST})	
public class StockController {

	@Autowired
	StockService stServ; 
	
	@GetMapping("/addStock")
	public boolean addStock(@RequestBody StockDTO s) {
		boolean stockAdded= stServ.addToSavedStocks(s); 
		System.out.println(s);
		System.out.println(stockAdded);
		return stockAdded;
	}

	@GetMapping("/delStock")
	public boolean delStock (@RequestBody Map<String, String> parameters) {  //(@RequestBody String symbol, @RequestBody String username) {
		String symbol= parameters.get("symbol");
		String username= parameters.get("username");
		boolean stockDeleted= stServ.deleteSavedStock(symbol,username); 
		System.out.println(symbol);
		System.out.println(stockDeleted);
		return stockDeleted;
	}
	
	@GetMapping("/getSavedStocks")
	public List<StockDTO> getSavedStocks(@RequestBody String username) {
		List<StockDTO> stocksList= stServ.getSavedStocks(username); 
		System.out.println(stocksList);
		return stocksList;
	}
}
