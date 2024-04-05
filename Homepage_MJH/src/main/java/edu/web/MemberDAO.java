package edu.web;


public interface MemberDAO {
	public abstract int insert(MemberVO vo);
	public abstract MemberVO select(String userid);
	public abstract int update(MemberVO vo);
	public abstract int delete(String userid);
	public abstract String select(String userid, String password);
}
