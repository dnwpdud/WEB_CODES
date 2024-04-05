package web.ch20.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestFilter extends HttpFilter implements Filter{
	// * Filter의 목적
	// - 서버의 리소스에 접근하기 전에 클라이언트의 요청/응답을 인터셉트하는 기능
	// - 클라이언트와 서버 간의 요청/응답을 조작
	
	// * Filter의 유형
	// - 인증
	// - 데이터 압축
	// - 암호화
	// - 로그/감시
	// - 이미지 변환
	// - charEncodingSet
	
	// * Filter 사용법
	// - web.xml 파일에 필터 태그 추가
	
	public TestFilter() {
		System.out.println("TestFilter 생성자");
	}
	
	// init() : 필터가 시작할 때 호출
	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	// doFilter() : 필터를 사용할 때마다 호출
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 클라이언트로부터 IP 얻기
		String ipAddress = req.getRemoteAddr();
		req.setCharacterEncoding("utf-8");
		// 현재 시간과 IP 주소 출력
		System.out.println("IP : " + ipAddress + 
				", Time" + new Date().toString()); // ip 주소을 보고 시간을 보는거
		chain.doFilter(req, res);
	}
	
	// destroy() : 필터가 종료될 때 호출
	public void destroy() {
	}
	
}









