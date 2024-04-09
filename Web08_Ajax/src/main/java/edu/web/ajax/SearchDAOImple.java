package edu.web.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import oracle.jdbc.OracleDriver;

public class SearchDAOImple implements SearchDAO, SearchQuery {

	@Override
	public ArrayList<String> select(String title) {
		ArrayList<String> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
	        
	        rs = pstmt.executeQuery(); 
	        
	        list = new ArrayList<>();
	        
	        while(rs.next()) { 
				int sno = rs.getInt(COL_SNO); 
				title = rs.getString(COL_TITLE); 
				
				SearchVO vo = new SearchVO(sno, title);
				list.add(title);
			}
	        
	        
	        System.out.println("SQL_SELECT 성공");
	        
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
