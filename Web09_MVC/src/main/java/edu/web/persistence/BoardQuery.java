package edu.web.persistence;

public interface BoardQuery {
	public static final String TABLE_NAME = "BOARD";
	public static final String COL_BOARD_ID = "BOARD_ID";
	public static final String COL_BOARD_TITLE = "BOARD_TITLE";
	public static final String COL_BOARD_CONTENT = "BOARD_CONTENT";
	public static final String COL_MEMBER_ID = "MEMBER_ID";
	public static final String COL_BOARD_DATE_CREATED = "BOARD_DATE_CREATED";
	
	// 게시글 등록
	// INSERT INTO BOARD 
	// VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE);
	public static final String SQL_INSERT = 
			"INSERT INTO " + TABLE_NAME + " VALUES " 
			+ "(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
	
	// 전체 게시글 조회
	//	SELECT * FROM BOARD ORDER BY BOARD_ID DESC;
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME + 
			" ORDER BY " + COL_BOARD_ID + " DESC";
	
	// 상세 게시글 조회
	//	SELECT * FROM BOARD 
	//	WHERE BOARD_ID = 1;
	public static final String SQL_SELECT_BY_BOARD_ID = 
			"SELECT * FROM " + TABLE_NAME + " WHERE "
			+ COL_BOARD_ID + " = ?";
	
	// 상세 게시글 수정
//	UPDATE BOARD 
//	SET
//	BOARD_TITLE = 'TEST', 
//	BOARD_CONTENT = 'TEST', 
//	BOARD_DATE_CREATED = SYSDATE
//	WHERE BOARD_ID = 1;
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET "
			+ COL_BOARD_TITLE + " = ?, "
			+ COL_BOARD_CONTENT + " = ?, "
			+ COL_BOARD_DATE_CREATED + " = SYSDATE "
			+ "WHERE " + COL_BOARD_ID + " = ?";
			
	// 상세 게시글 삭제
	// DELETE BOARD WHERE BOARD_ID = ?
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + 
			" WHERE " + COL_BOARD_ID + " = ?";
	
	// 게시글 페이징 처리
	// SELECT * FROM(
    // SELECT ROW_NUMBER() OVER (ORDER BY BOARD_ID DESC) AS RN, BOARD.* 
    // FROM BOARD
	// ) WHERE RN BETWEEN ? AND ?;
	// 가상의 컬럼을 만들어서 특정순서(여기선 내림차순)에 맞게 정열 하는 쿼리 여기까지가 ()안의 내용
	// " WHERE RN BETWEEN ? AND ?" 여기는 정리된 데이터을 페이지로 나누는 퀴리
	   public static final String SQL_SELECT_PAGESCOPE = 
			   "SELECT * FROM("
				         + " SELECT ROW_NUMBER() OVER (ORDER BY BOARD_ID DESC) AS RN, BOARD.*"
				         + " FROM BOARD"
				         + ") WHERE RN BETWEEN ? AND ?";
	   
	   // SELECT COUNT(BOARD_ID) TOTAL_CNT FROM BOARD;
	   public static final String SQL_TOTAL_CNT = 
			   "SELECT COUNT(BOARD_ID) TOTAL_CNT FROM BOARD";
}








