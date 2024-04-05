package edu.web.member;

public interface MemberDAO {
	
	// 회원 등록
	public abstract int insert(MemberVO vo);
	
	// 회원 정보 검색
	public abstract MemberVO select(String userid);
	
	// 회원 정보 수정
	public abstract int update(String userid, MemberVO vo);
	
	// 회원 정보 삭제
	public abstract int delete(String userid);
	
	// 로그인 정보 비교
	public abstract boolean selectLogin(String userid, String password);
	// 강사님은 boolean으로 안하고 String의로 하셨다.
	
	// 스프링 이해하신 방법 학생분들이 오류을 내것을 해결하는 과정에서 스프링의 구조을 이해하시고 파악하셨다.
	// 퀴리와 리턴 타입의 결과물이 같은 것이 좋다. 왜냐하면 룰의 위함하는 행위이지만 코드적으로는 더 좋기 때문이다.
	// 나중에 과제 코드 다시 작성 할때는 로그인을 String 형태로 작성 하기
} // end MemberDAO
