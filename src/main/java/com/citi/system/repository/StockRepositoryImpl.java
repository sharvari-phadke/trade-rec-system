package com.citi.system.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.citi.system.dto.StockDTO;
import com.citi.system.utils.QueryUtils;

/*
 * This class will communicate with database for saved stocks (slide 2 of frontend)
 */

@Repository("StockRepository")
public class StockRepositoryImpl implements StockRepository{
	@Autowired
	DataSource datasource; 

	@Override
	public List<StockDTO> getSavedStocks(String user_name) {
		Connection con = null; 
		List<StockDTO> stocksList= new ArrayList<>();
		Map<String, Object> paramsMap= new HashMap<>();
		boolean connected= false;
		
		try {
			con= datasource.getConnection();
			connected= true;
		} catch (SQLException e) {
			connected= false;
			e.printStackTrace();
		}
		
		if(connected) {
			String symbol; 
			BigDecimal currPrice;
			BigDecimal close2WeeksAgo;
			Double changePercent;
			int quantity;
			Date dateSaved;
			String username;
			try {
				paramsMap.put("username", user_name);
				String getStocksList= QueryUtils.returnQueryString("getAllStocks", paramsMap);
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery(getStocksList);
				
				while(rs.next()) {
					symbol= rs.getString("symbol");
					currPrice= rs.getBigDecimal("currPrice");
					close2WeeksAgo= rs.getBigDecimal("close2WeeksAgo");
					changePercent= rs.getDouble("changePercent");
					quantity= rs.getInt("quantitySaved"); 
					username= rs.getString("username");
					StockDTO currStock= new StockDTO(symbol, currPrice, close2WeeksAgo, changePercent, quantity, username);
					stocksList.add(currStock);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return stocksList;
	}

	@Override
	public boolean deleteSavedStock(String stockSymbol, String username) {
		Connection con = null;
		Map<String, Object> paramsMap= new HashMap<>();
		boolean connected= false, isDeleted= false;
		
		try {
			con= datasource.getConnection();
			connected= true;
		} catch (SQLException e) {
			connected= false;
			e.printStackTrace();
		}
		
		if(connected) {
			try {
				paramsMap.put("username", username);
				paramsMap.put("symbol", stockSymbol);
				String delStockQry= QueryUtils.returnQueryString("deleteStock", paramsMap);
				Statement st = con.createStatement();
//				System.out.println(delStockQry+ " : delStockQry");
				int numDeleted= st.executeUpdate(delStockQry);
				System.out.println(numDeleted+ " : deleted");
				
				if(numDeleted == 0) {
					isDeleted= false;
				}else {
					isDeleted= true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean addToSavedStocks(StockDTO stock) {
		Connection con = null;
		Map<String, Object> paramsMap= new HashMap<>();
		boolean connected= false, isAdded= false;
		
		try {
			con= datasource.getConnection();
			connected= true;
		} catch (SQLException e) {
			connected= false;
			e.printStackTrace();
		}
		
		if(connected) {
			try { 				
				paramsMap.put("stock", stock);
				paramsMap.put("symbol",stock.getSymbol());
				paramsMap.put("currPrice", stock.getCurrPrice());
				paramsMap.put("close2WeeksAgo", stock.getClose2WeeksAgo()); 
				paramsMap.put("changePercent", stock.getChangePercent());
				paramsMap.put("quantitySaved", stock.getQuantitySaved()); 
				paramsMap.put("username", stock.getUsername());
				Statement st = con.createStatement();
				int numDeleted= 0;
				
				String getStockQry= QueryUtils.returnQueryString("getStock", paramsMap);
				int rs= st.executeUpdate(getStockQry); 
				
				if(rs > 0) {
					String delStockQry= QueryUtils.returnQueryString("deleteStock", paramsMap);
					numDeleted=  st.executeUpdate(delStockQry);
					System.out.println(numDeleted+ " : deleted");
					
				}
				
				String addStockQry= QueryUtils.returnQueryString("addStock", paramsMap);
				System.out.println(addStockQry+ " : addStockQry");
				int numAdded= 0;
				if(stock.getUsername()!=null && stock.getQuantitySaved()>0) {
					numAdded= st.executeUpdate(addStockQry);
				}
				System.out.println(numAdded+ " : added");

				if(numAdded == 0) {
					isAdded= false;
				}else {
					isAdded= true;
				}
				
			} catch (SQLException e) {
				isAdded= false;
				e.printStackTrace();
			} 
		}
		
		return isAdded; 
	}
}
