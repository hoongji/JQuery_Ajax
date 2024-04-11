package edu.web.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import oracle.jdbc.OracleDriver;

public class SearchDAOImple implements SearchDAO, SearchQuery {
	// ?? getInstance
	private static SearchDAOImple instance = null;
	
	private SearchDAOImple() {}
	
	public static SearchDAOImple getInstance() {
		if(instance == null) {
			instance = new SearchDAOImple();
		}
		return instance;
	}
	
	
	@Override
	public ArrayList<String> select(String keyword) {
		ArrayList<String> list = null;
		// ArrayList<String> list = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
	       
			pstmt.setString(1,"%" +  keyword + "%");  // 추가 
	        rs = pstmt.executeQuery(); 
	        
	        list = new ArrayList<>();
	        
	        while(rs.next()) { 
				 
				String title = rs.getString(COL_TITLE); 
				System.out.println(title);
			
				list.add(title); // vo 추가 필요없이 LIST에 담기만 하면 됨 
			}
	        
	      
	        
	    } catch (SQLException e) {
	        System.out.println(e.toString());
	        e.printStackTrace();
	    } finally {
	        try {
	           rs.close();
	           pstmt.close();
	           conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	        }
	    }
		
		return list;
		
	}



}
