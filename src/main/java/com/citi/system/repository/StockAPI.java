package com.citi.system.repository;


import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.citi.system.dto.StockDTO;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import yahoofinance.histquotes2.QueryInterval;
import yahoofinance.query2v8.HistQuotesQuery2V8Request;

public class StockAPI {
	
	//returns list of stockDTO objects
	public List<StockDTO> getStock(String[] Stocks) throws IOException {
		
		List<StockDTO> info= new ArrayList<>();
		for(String stockName: Stocks) {
			StockDTO dto = null;
			Stock stock = YahooFinance.get(stockName);
//			System.out.println("STOCK QUOTE\n\n\n"+ stock);
//			System.out.println("getQuote  "+ stock.getQuote());
//			System.out.println("getDividend  "+ stock.getDividend());
//			System.out.println("getStats  "+ stock.getStats());
			System.out.println("getPrice  "+ stock.getQuote().getPrice());
			System.out.println("getChange  "+ stock.getQuote());
//			dto = new StockDTO(stock.getSymbol(), stock.getQuote().getPrice(), stock.getQuote().getChange(),stock.getQuote().getBid(), null, null, 0, stockName);
			info.add(dto);
		}
		
		return info;
	}
	
	
	public void getHistory(String[] stockNames){ 
		//finding price from 14 days ago
		/*
		Map<String,BigDecimal> history = null;
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.DATE, -14); 
		
		for(String stockName: stockNames) {
			System.out.println(stockNames);
			System.out.println(stockName);
			Stock currentStock = YahooFinance.get(stockName, from, to, Interval.WEEKLY);
			history.put(stockName, currentStock.getQuote().getPrice());
			System.out.println("HISTORY");
			System.out.println(history);
		}
		*/
	}
	/*
	public static void main(String[] args) throws IOException {
		StockAPI stockAPI = new StockAPI();
		//System.out.println(stockAPI.getStock("GOOG"));
		
		String[] small_cap = new String[] {"ALOKINDS.NS","AMARAJABAT.NS","AMBER.NS","ANGELONE.NS","ANURAS.NS","BAJAJELEC.NS","BALAMINES.NS","MAHABANK.NS","BIRLACORPN.NS","BSOFT.NS",
				"CESC.NS","CANFINHOME.NS","CENTRALBK.NS","CDSL.NS","CHAMBLFERT.NS","CHEMPLASTS.NS","CAMS.NS","CYIENT.NS","DEVYANI.NS","DBL.NS","FSL.NS","GRANULES.NS","GRAPHITE.NS",
				"HEG.NS","HFCL.NS","HINDCOPPER.NS","IDFC.NS","IBULHSGFIN.NS","IOB.NS","INDIGOPNTS.NS","INTELLECT.NS","JBCHEPHARM.NS","JUBLINGREA.NS","KPITTECH.NS","LATENTVIEW.NS",
				"LXCHEM.NS","MEDPLUS.NS","METROBRAND.NS","MCX.NS","NBCC.NS","PNBHOUSING.NS","PVR.NS","POONAWALLA.NS","RBLBANK.NS","RADICO.NS","ROUTE.NS","STLTECH.NS","UTIAMC.NS","WELSPUNIND.NS","ZENSARTECH.NS"};
		
		String[] mid_cap = new String[] {"ABB.NS","AUBANK.NS","AARTIIND.NS","ABBOTINDIA.NS","ALKEM.NS","ASHOKLEY.NS","ASTRAL.NS","AUROPHARMA.NS","BALKRISIND.NS","BATAINDIA.NS","BEL.NS","BHARATFORG.NS",
				"BHEL.NS","CANBK.NS","COFORGE.NS","CONCOR.NS","CUMMINSIND.NS","ESCORTS.NS","FEDERALBNK.NS","GODREJPROP.NS","GUJGASLTD.NS","HAL.NS","HINDPETRO.NS","IDFCFIRSTB.NS","IRCTC.NS",
				"JINDALSTEL.NS","L&TFH.NS","LTTS.NS","LICHSGFIN.NS","MRF.NS","M&MFIN.NS","MFSL.NS","MPHASIS.NS","OFSS.NS","PAGEIND.NS","PETRONET.NS","PFC.NS","RECLTD.NS","SRTRANSFIN.NS","SUNTV.NS","TVSMOTOR.NS",
				"TATACOMM.NS","TATAPOWER.NS","RAMCOCEM.NS","TORNTPOWER.NS","TRENT.NS","UBL.NS","IDEA.NS","VOLTAS.NS","ZEEL.NS"};
		
		String[] large_cap = new String[] {"ACC.NS","ADANIENT.NS","ADANIGREEN.NS","ADANITRANS.NS","AMBUJACEM.NS","DMART.NS","BAJAJHLDNG.NS","BANDHANBNK.NS","BANKBARODA.NS","BERGEPAINT.NS","BIOCON.NS","BOSCHLTD.NS",
				"CHOLAFIN.NS","COLPAL.NS","DLF.NS","DABUR.NS","NYKAA.NS","GAIL.NS","GLAND.NS","GODREJCP.NS","HDFCAMC.NS","HAVELLS.NS","ICICIGI.NS","ICICIPRULI.NS","IOC.NS","INDUSTOWER.NS","NAUKRI.NS","INDIGO.NS",
				"JUBLFOOD.NS","LTI.NS","LUPIN.NS","MARICO.NS","MINDTREE.NS","MUTHOOTFIN.NS","NMDC.NS","PAYTM.NS","PIIND.NS","PIDILITIND.NS","PEL.NS","PGHH.NS","PNB.NS","SBICARD.NS","SRF.NS","SIEMENS.NS",
				"SAIL.NS","TORNTPHARM.NS","MCDOWELL-N.NS","VEDL.NS","ZOMATO.NS","ZYDUSLIFE.NS"};
		//stockAPI.getHistory("ALOKINDS.NS");
		
	}*/
}