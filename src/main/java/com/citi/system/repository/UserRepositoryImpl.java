package com.citi.system.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.citi.system.dto.StockDTO;
import com.citi.system.dto.User;
import com.citi.system.utils.QueryUtils;

@Repository("UserRepository")
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	DataSource datasource; 

	@Override
	public boolean verifyUser(User user) {
		Connection con = null; 
		Map<String, Object> paramsMap= new HashMap<>();
		String pwd= "";
		boolean isUserValid= false;
		boolean connected= false;
		
		try {
			con= datasource.getConnection();
			connected= true;
		} catch (SQLException e) {
			connected= false;
			e.printStackTrace();
		}

		if(connected) {
			try {
				paramsMap.put("username", user.getUsername());
				String getPasswordQry= QueryUtils.returnQueryString("getPwdForUserName", paramsMap);
				Statement st= con.createStatement();
				 System.out.println(getPasswordQry+ " : getPasswordQry");
				ResultSet rs= st.executeQuery(getPasswordQry);
				while(rs.next()) {
					pwd = rs.getString("password");
				}
//				System.out.println(rs.toString()+ " : rs "+rs.getString("password"));
				if(pwd.equals(user.getPassword())) {
					isUserValid= true;
					System.out.println(pwd+ " : found pwd");
				}else isUserValid= false;
			} catch (SQLException e) {
				connected= false;
				e.printStackTrace();
			}
		}

		System.out.println(isUserValid+ " : isUserValid");
		
		return isUserValid;
	}

	
}
