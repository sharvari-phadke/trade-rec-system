package com.citi.system.utils;
 
import java.util.Map;  
import org.springframework.stereotype.Repository;

@Repository
public class QueryUtils { 
	
	public static String returnQueryString(String queryName, Map<String,Object> params){
		String sqlQuery=""; 
		
		switch (queryName) {
		case "getPwdForUserName":
			sqlQuery= "select password from user_info where username = '"+ params.get("username").toString()+"'"; 
			break; 
		case "getAllStocks":
			sqlQuery= "select * from savedstocks where username= '"+params.get("username").toString()+"'";
			break;
		case "getStock":
			sqlQuery= "select * from savedstocks where username= '"+params.get("username").toString()+"' and symbol = '"+params.get("symbol").toString()+"'";
		case "deleteStock":
			sqlQuery= "delete from savedstocks where username= '"+params.get("username").toString()+"' and symbol = '"+params.get("symbol").toString()+"'";
			break;
		case "addStock":
			sqlQuery= "insert into savedstocks (symbol, currPrice, close2WeeksAgo, changePercent, quantitySaved, username ) values ( '"
						+ params.get("symbol").toString()+"',"+ params.get("currPrice")+", "+ params.get("close2WeeksAgo")+", "
						+ params.get("changePercent")+", "+ params.get("quantitySaved")+", '"+ params.get("username")+"' )";
			break;
		case "updateStock":
			sqlQuery= "update savedstocks set currPrice="+ params.get("currPrice")+", close2WeeksAgo= "+ params.get("close2WeeksAgo")
					+", changePercent= " + params.get("changePercent")+", quantitySaved= "+ params.get("quantitySaved")
					+" where username= '"+params.get("username").toString()+"' and symbol = '"+params.get("symbol").toString()+"'";
			break;
		
		}
		return sqlQuery;
	}

}
