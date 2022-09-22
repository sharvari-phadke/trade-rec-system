package com.citi.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api/stockrecs", method = {RequestMethod.GET, RequestMethod.POST})	
public class RecsController {

	@Autowired
	StockRecService stRecServ;
	
	@GetMapping("/getSavedStocks")
	public List<StockDTO> getStockRecs(@RequestBody String mkt_cap) throws IOException{
		List<StockDTO> stocks= new ArrayList<>();
		CapWiseStockSymbols stockSymbols= new CapWiseStockSymbols();
		if(mkt_cap== "small") {
			stocks= stRecServ.getStockRecs(stockSymbols.getSmall_cap());
		}
		if(mkt_cap== "mid") {
			stocks= stRecServ.getStockRecs(stockSymbols.getMid_cap());
		}
		if(mkt_cap== "large") {
			stocks= stRecServ.getStockRecs(stockSymbols.getLarge_cap());
		}
		
		return stocks;
	}
}
