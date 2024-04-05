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

// TODO : loginResult.jsp에서 이동
// 로그인된 사용자의 정보를 DB에서 select
// select된 MemberVO 데이터를 memberResult.jsp로 전송

@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;   
  
    public SelectServlet() {
    dao = MemberDAOImple.getInsttance();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		System.out.println(userid);
		
		if(userid != null){ // 세션 값이 있으면 출력
			
			MemberVO vo = dao.select(userid);
			
			ServletContext context = getServletContext();
			request.setAttribute("vo", vo);
			System.out.println("정보 출력 완료");
			// 클라이언트로부터 발생된 요청을 다른 결로의 리소스(Servlet or jsp)로 전송 하는역할
	    	RequestDispatcher dispatcher = 
	    	request.getRequestDispatcher("memberResult.jsp");
	
	    	// request와 response를 포워딩(전송) // 부탁, 요청 역할
	    	dispatcher.forward(request, response); 
			
		} else {
			// url로 접근할 경우(GET) 경로 변경
			response.sendRedirect("login.jsp");
	    	
			System.out.println("로그인 해주세요.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
