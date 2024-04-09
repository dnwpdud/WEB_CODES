package edu.web.search;

public interface DBcurie {
		// DB 접속에 필요한 상수 정의
		public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		public static final String USER = "scott";
		public static final String PASSWORD = "tiger";
		
		// DB 테이블 컬럼 상수 정의
		public static final String TABLE_NAME = "SEARCH";
		public static final String COL_SNO = "SNO";
		public static final String COL_TITLE = "TITLE";
		
		// 글자 정보 검색
		// SELECT TITLE FROM SEARCH

		public static final String SQL_SELECT_BY_TITLE = 
				"SELECT " + COL_TITLE + " FROM " + TABLE_NAME;
		
		// 글자가 포함되어 있으면 출력
		public static final String SQL_SELECT_TITLE = 
				"SELECT " + COL_TITLE + " FROM " + TABLE_NAME +
				" WHERE " + COL_TITLE + " LIKE ?";
}
