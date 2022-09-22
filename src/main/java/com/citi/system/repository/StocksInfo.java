//package com.citi.system.repository;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Comparator;
//import java.util.List;
//import java.util.PriorityQueue;
//
//import com.citi.system.dto.StockDTO;
//
//import yahoofinance.histquotes.HistoricalQuote;
//import yahoofinance.histquotes2.QueryInterval;
//import yahoofinance.query2v8.HistQuotesQuery2V8Request;
//
//public class StocksInfo {
//	public ArrayList<StockDTO> getStockRecs(String[] symbols) throws IOException {		
//		Comparator<StockDTO> comp= new Comparator<StockDTO>() {
//			public int compare(StockDTO stock1, StockDTO stock2) {
//				if (stock1.getChangePercent() < stock2.getChangePercent()) {
//					return 1;
//				}
//				else if (stock1.getChangePercent() > stock2.getChangePercent()) {
//					return -1;
//				}
//				else return 0;
//			};
//		};
//
//		PriorityQueue<StockDTO> allStocks= new PriorityQueue<>(comp);
//		ArrayList<StockDTO> stockRecs= new ArrayList<>();
//		Calendar from = Calendar.getInstance();
//		Calendar to = Calendar.getInstance();
//		from.add(Calendar.DATE, -14);
//
//		for(String stockSymb: symbols) {
//			HistQuotesQuery2V8Request hist = new HistQuotesQuery2V8Request(stockSymb, from, to, QueryInterval.WEEKLY); 
//			List<HistoricalQuote> quotes = hist.getResult();
//			Double change= getChangePercent(quotes);
//			/*
//			 * DATES
//
//				Fri Sep 02 09:15:00 IST 2022
//				Fri Sep 16 13:00:31 IST 2022
//			 */
//			StockDTO currStock= new StockDTO(stockSymb, quotes.get(quotes.size()-1).getClose(), quotes.get(0).getClose(), change, 0, null);
//			allStocks.add(currStock);
//		}
//
//		int count= 0;
//		while(count< 5) {
//			System.out.println(allStocks.peek().getChangePercent());
//			stockRecs.add(allStocks.poll());
//			count++;
//		}
//		return stockRecs;
//
//	}
//
//	private static Double getChangePercent(List<HistoricalQuote> quotes) {
//		Double change= 0.0, changePercent= 0.0;
//		int lastIndex= quotes.size()-1;
//		change= quotes.get(lastIndex).getClose().doubleValue()- quotes.get(0).getClose().doubleValue();
//		changePercent= change*100/ quotes.get(0).getClose().doubleValue();
//
//		return changePercent;
//	}
//
//}
//
