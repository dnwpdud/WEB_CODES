package edu.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("*.go")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String LOGIN_URL = "WEB-INF/login/";
//	private static final String REGISTER = "register";
	private static final String LOGIN = "login";
	private static final String LOGOUT = "logout";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".go";
	private static final String MAIN = "index";
	
    public LoginController() {

    }
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String requestURI = request.getRequestURI(); // 접속경로 변수 
		String requestMethod = request.getMethod(); // 
		System.out.println("호출 경로 : " + requestURI); // 여기 접속한 경로 이름
		System.out.println("호출 방식 : " + requestMethod); // 접속 방식
    	
		if(requestURI.contains(LOGIN)) {
			System.out.println("login 호출 확인");
			if(requestMethod.equals("GET")) {
				loginGET(request, response);
			} else if(requestMethod.equals("POST")) {
				loginPOST(request, response);
			}
			
			} else if(requestURI.contains(LOGOUT + SERVER_EXTENSION)) {
				System.out.println("logout 호출 확인");
				logout(request, response);
			}
			
		}// end service
	
    private void loginGET(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    		String targetURL = request.getParameter("targetURL");
    	
    		System.out.println("loginGET()");
    		request.setAttribute("targetURL", targetURL);
    	
    	
    		String path = LOGIN_URL + LOGIN + EXTENSION;
    
    		
    		request.getRequestDispatcher(path).forward(request, response);
    	
		
	}// end loginGET()
    
    private void loginPOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	System.out.println("loginPOST()");
    	 String memberId = request.getParameter("memberId");
		 String password = request.getParameter("password");
		 String targetURL = request.getParameter("targetURL");
		 
		 System.out.println(memberId);
		 System.out.println(password);
		 
		 // * loginPOST를 수행하는 상황
		 // - index.jsp에서 login 버튼 클릭 - 로그인 페이지 - 로그인 성공 - index.jsp 이동
		 // - 글 작성 버튼(register.do) 클릭 - 로그인 페이지 - 로그인 성공 - register.do 이동
		 
		 if(memberId.contains("test") && password.equals("1234")) {
			  System.out.println("로그인 성공.");
			  // 자바에서도 세션을 사용할 수 있도록 하는 인터페이스
			  HttpSession session = request.getSession();
			  
			  // 세션 생성
			  session.setAttribute("memberId", memberId);
		
			  // 세션 유지 시간 
			  session.setMaxInactiveInterval(10);
			 
			  //String targetURL = MAIN + EXTENSION;
			  if(!targetURL.equals("") && targetURL != null) { // 비어있지않고 null이 아닐경우
				  System.out.println(targetURL);
				  response.sendRedirect(targetURL); //강사님 코드
			  } else {
				  response.sendRedirect("index.jsp");
			  }
	    		
//			  RequestDispatcher dispatcher
//				= request.getRequestDispatcher(path);
//	    		
//			  request.setAttribute("memberId", memberId);
//	    		
//			  dispatcher.forward(request, response);  index.jsp
			  
			  
		 } else {
			 response.sendRedirect("ingin.go");
		 }
		
	} // end loginPOST

	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("logout()");
		
		HttpSession session = request.getSession();
		
		String memberId = (String)session.getAttribute("memberId");
		System.out.println(memberId);
		
	 	if(memberId != null){
	 		
	 		// 세션 없애는 기능
	 		session.removeAttribute("memberId");
	    	// 페이지 경로 이동 기능 
	 		
	 		System.out.println("로그아웃 성공.");
	 		
	 		String path = MAIN + EXTENSION;
	 		
	    	response.sendRedirect(path);

	 	} else {
	 		System.out.println("로그아웃 실패");
	 		String path = MAIN + EXTENSION;
	 		
	    	response.sendRedirect(path);
	 	}
		
	} // end logout
	
} // end LoginController
