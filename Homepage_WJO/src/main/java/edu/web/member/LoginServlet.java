package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/*
 * TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서
 * 데이터가 일치하면 - 로그인 세션 생성 및 로그인 성공(loginResult.jsp)로 이동
 * (아이디 값에 대한 세션 생성. 세션 만료 시간 60초)
 * 데이터가 일치하지 않으면 - login.jsp로 이동(심심하면 실패 alert 띄우기)
 * */

@WebServlet("/loginAuth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	private static final String CLASSNAME
 	= RegisterServlet.class.getName(); // 클래스 위치와 이름 참조
	
	 

    public LoginServlet() {
    	dao = MemberDAOImple.getInsttance();	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()");
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  
		  String userid = request.getParameter("userid");
		  String password = request.getParameter("password");
		  
		  System.out.println(userid);
		  System.out.println(password);
		  
		  if(dao.selectLogin(userid, password)) {
			  // 자바에서도 세션을 사용할 수 있도록 하는 인터페이스
			  HttpSession session = request.getSession();
			  
			  // 세션 생성
			  session.setAttribute("userid", userid);
		
			  // 세션 유지 시간 
			  session.setMaxInactiveInterval(10);
			  
			  System.out.println("로그인 성공.");
			  
			  response.sendRedirect("loginResult.jsp"); 
	
		  } else {
			    System.out.println("아이디와 비밀번호을 다시 확인해주세요.");
			    response.sendRedirect("login.jsp");  
	}

	}
}
	
