package edu.web.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class SearchDAOImple implements DBcurie, SearchDAO {
	
	private static SearchDAOImple instance = null;
	
	private SearchDAOImple() {
		
	}
	
	public static SearchDAOImple getInsttance() {
		if(instance == null) {
			instance = new SearchDAOImple();
		}
		return instance;
	}
	
	private void closeResource(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("로그 작성 하는것이 좋다. 어디에서나 로그을 찍느것이 가장좋다. 특히 여기");
			e.printStackTrace();
		}
	}

	// 값이 있을 때 동작하는 코드
	@Override
	public ArrayList<SearchVO> select(String title) {
		System.out.println("공백 아닌경우");
		System.out.println(title);
		ArrayList<SearchVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 3. Oracle JDBC 드라이버를 메모리에 로드
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("JDBC드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_SELECT_TITLE);
			pstmt.setString(1, "%" + title + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String result  = rs.getString(1);
				
				SearchVO vo = new SearchVO(result);
				
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, rs);
		}
		return list;
	}

	// 값이 null일때 동작하는 코드
	@Override
	public ArrayList<SearchVO> selectALL() {
		System.out.println("공백");
		ArrayList<SearchVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("JDBC드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String result  = rs.getString(1);
				
				SearchVO vo = new SearchVO(result);
				
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, rs);
			System.out.println("close 완료");
		}
		return list;
	}
	
}
