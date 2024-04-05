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

// TODO : 로그인된 사용자만 접근 가능.
// userid 세션을 제거하고, login.jsp로 이동

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME
 	= RegisterServlet.class.getName(); // 클래스 위치와 이름 참조

    public LogoutServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		System.out.println(userid);
	 	if(userid != null){
	 		
	 		// 세션 없애는 기능
	 		session.removeAttribute("userid");
	    	// 페이지 경로 이동 기능 
	    	response.sendRedirect("login.jsp");
	    	
			System.out.println("로그아웃 성공.");
	 	} else {
	 		System.out.println(CLASSNAME + " doGet()");
	 		System.out.println("로그아웃 실패");
	 		response.sendRedirect("login.jsp");
	 		
	 	}
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
