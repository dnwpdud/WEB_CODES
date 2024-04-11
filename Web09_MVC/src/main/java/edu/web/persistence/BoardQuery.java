package edu.web.persistence;

public interface BoardQuery {
	public static String TABLE_NAME = "BOARD";
	public static String COL_BOARD_ID = "BOARD_ID";
	public static String COL_BOARD_TITLE = "BOARD_TITLE";
	public static String COL_BOARD_CONTENT = "BOARD_CONTENT";
	public static String COL_MEMBER_ID = "MEMBER_ID";
	public static String COL_BOARD_DATE_CREATED = "BOARD_DATE_CREATED";
	
	// 게시글 등록
	//INSERT INTO BOARD
	//VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE);
	public static final String SQL_INSERT = 
			"INSERT INTO " +  TABLE_NAME 
			+ " VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, sysdate)";
	
	// 게시글 전체 조회
	//SELECT * FROM BOARD 
	//ORDER BY BOARD_ID DESC
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME + 
			" ORDER BY " + COL_BOARD_ID + " DESC";
	//" ORDER BY " + COL_BOARD_ID + " DESC" 아이디을 기준으로 내림 차순으로 정렬
	// 그냥 전체 검색한면 내가 원하는데로 안나올수 있어 정렬로한것이다.
	
	// 게시글 조회
	// SELECT * FROM BOARD 
	// WHERE BOARD_ID = ?
	public static final String SQL_SELECT_BY_BOARD_ID = 
			"SELECT * FROM " + TABLE_NAME + 
			" WHERE " + COL_BOARD_ID + " = ?";
	
	// 상세 게시글 수정
	// UPDATE BOARD SET 
	// BOARD_TITLE = 'Q', 
	// BOARD_CONTENT = 'Q',
	// BOARD_DATE_CREATED = sysdate
	// WHERE BOARD_ID = 1;
	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME + " SET " + 
			COL_BOARD_TITLE + " = ?, " + 
			COL_BOARD_CONTENT + " = ?, " +
			COL_BOARD_DATE_CREATED + " = sysdate " +
			"WHERE " + COL_BOARD_ID + " = ?";
	// 중간 데이터을 구지 수정안할거면 안해도 된다.
	
	// 게시글 삭제
	public static final String SQL_DELETE = 
			"DELETE "+ TABLE_NAME +
			" WHERE " + COL_BOARD_ID + " = ?";
}
