package edu.web.ajax;

public interface SearchQuery {
	// DB 접속에 필요한 상수 정의
		public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		public static final String USER = "scott";
		public static final String PASSWORD = "tiger";
		
		// DB 테이블 컬럼 상수 정의
		public static final String TABLE_NAME = "SEARCH";
		public static final int COL_SNO = 0;
		public static final String COL_TITLE = "TITLE";
		
		
		
		

	    
		// SELECT TLTLE FROM TEST_MEMBER WHERE TITLE = ?
	 	public static final String SQL_SELECT_BY_TITLE = 
	 			"SELECT " + COL_TITLE + " FROM " + TABLE_NAME + " WHERE " + COL_TITLE + " LIKE" + " ?";
	 	
	 	
	 	
}
