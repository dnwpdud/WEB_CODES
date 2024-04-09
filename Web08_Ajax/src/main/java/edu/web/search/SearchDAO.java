package edu.web.search;

import java.util.ArrayList;

public interface SearchDAO {
	// 글자에 맞게 추천코드
	public abstract ArrayList<SearchVO> select(String title);
	
	// 공백일때 출력
	public abstract ArrayList<SearchVO> selectALL();
}
