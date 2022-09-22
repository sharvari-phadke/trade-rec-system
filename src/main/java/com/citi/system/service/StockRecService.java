package com.citi.system.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.citi.system.dto.StockDTO;

import yahoofinance.histquotes.HistoricalQuote;


public interface StockRecService {
	ArrayList<StockDTO> getStockRecs(String[] symbols) throws IOException;
}
