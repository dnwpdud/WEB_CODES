package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;


public class MemberDAOImple implements DBConnection, MemberDAO {
	
	private static MemberDAOImple instance = null;

	
	
	private MemberDAOImple() {
		
	}
	
	
	public static MemberDAOImple getInsttance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	// conn, pstmt 리소스 해제 함수
	private void closeResource(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("로그 작성 하는것이 좋다. 어디에서나 로그을 찍느것이 가장좋다. 특히 여기");
			e.printStackTrace();
		}
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
	
	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()");
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행 등록");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt);
		}
		
		return result;
	}


	@Override
	public MemberVO select(String userid) {
		System.out.println("select()");
		MemberVO vo = new MemberVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(userid);
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("jdbc드라이버 로드");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//userid = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				String emailAgree = rs.getString(4);
				String[] interest = rs.getString(5).split(userid);
				String phone = rs.getString(6);
				String introduce = rs.getString(7);
			
				vo = new MemberVO(userid, password, email, emailAgree
						, interest, phone, introduce);
				System.out.println(vo);
			} else {
				System.out.println("검색에 실패 했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, rs);
		}
		return vo;
	}


	@Override
	public int update(String userid, MemberVO vo) {
		System.out.println("update()");
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("jdbc 드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.getInterestJoin());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, userid);
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(result + "행이 수정됐습니다.");
			} else {
				System.out.println("수정에 실패 했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int delete(String userid) {
		System.out.println("delete()");
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("jdbc드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println(result + "행이 삭제됐습니다.");
			} else {
				System.out.println("탈퇴 실패 했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public boolean selectLogin(String userid, String password) {
		System.out.println("selectLogin()");
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_LOGIN);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
} // end MemberDAOImple
