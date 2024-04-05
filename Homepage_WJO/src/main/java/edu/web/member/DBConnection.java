package edu.web.member;

public interface DBConnection {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	// DB 테이블 컬럼 상수 정의
	public static final String TABLE_NAME = "TEST_MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public static final String COL_INTEREST = "INTEREST";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_INTRODUCE = "INTRODUCE";
	
	// 회원 정보 등록
	// INSERT INTO TEST_MEMBER VALUES
	// (?, ?, ?, ?, ?, ?, ?)
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME
			+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	// 회원 정보 검색
	// SELECT * FROM TEST_MEMBER 
	// WHERE USERID = ?
	public static final String SQL_SELECT_BY_USERID = 
			"SELECT * FROM " + TABLE_NAME + 
			" WHERE " + COL_USERID + " = ?";
	
	// 회원 정보 수정
	// UPDATE TEST_MEMBER SET 
	// PASSWORD = ?, EMAIL = ?, 
	// EMAIL_AGREE = ?, INTEREST = ?, PHONE = ?, INTRODUCE = ?
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET " +
					COL_PASSWORD + " = ?, " +
					COL_EMAIL + " = ?, " +
					COL_EMAIL_AGREE + " = ?, " +
					COL_INTEREST + " = ?, " +
					COL_PHONE + " = ?, " +
					COL_INTRODUCE + " = ? " +
					"WHERE " + COL_USERID + " = ?";
	
	// 회원 정보 삭제
	// DELETE TEST_MEMBER WHERE USERID = ?
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE "
				+ COL_USERID + " = ?";
	
	// 로그인 확인 쿼리
	// "SELECT * FROM TEST_MEMBER 
	// WHERE USERID = ? AND PASSWORD = ?"
	public static final String SQL_LOGIN =
	"SELECT * FROM " + TABLE_NAME + 
	" WHERE " + COL_USERID + " = ? " + "AND "
	+ COL_PASSWORD + " = ?";
	
	// 강사님 코드는 * 되신 
	// 전체 데이터을 검색 해서 확인 하고 가져오기 때문에 비효율적이다.
} // end DBConnection
