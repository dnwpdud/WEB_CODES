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

// TODO : memberResult.jsp에서 이동
// 		  로그인된 사용자 아이디를 가져와서 DB에 회원 정보 삭제
// 		  삭제 성공 후에 login.jsp 페이지로 이동
@WebServlet("/delete.do") 
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;
	private static final String CLASSNAME
 	= RegisterServlet.class.getName(); // 클래스 위치와 이름 참조
    
    public DeleteServlet() {
    	dao = MemberDAOImple.getInsttance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		
		if(userid != null) {
			int result = dao.delete(userid);
			if(result == 1) {
				session.removeAttribute("userid");
				response.sendRedirect("login.jsp");
				System.out.println("회원 탈퇴 완료");
			} else {
				System.out.println(result + "실패");
			}
		} else {
			response.sendRedirect("memberResult.jsp");
			System.out.println("실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		
		if(userid != null) {
			dao.delete(userid);
			
			ServletContext context = getServletContext();
			
			// 클라이언트로부터 발생된 요청을 다른 결로의 리소스(Servlet or jsp)로 전송 하는역할
	    	RequestDispatcher memberResult = context.getRequestDispatcher("/login.jsp");
	    	
	    	// request와 response를 포워딩(전송) // 부탁, 요청 역할
	    	memberResult.forward(request, response); 
			System.out.println("회원 탈퇴 완료");
			
		} else {
			 // 애플리케이션 정보 제공
			ServletContext context = getServletContext();
			
			// 클라이언트로부터 발생된 요청을 다른 결로의 리소스(Servlet or jsp)로 전송 하는역할
	    	RequestDispatcher loginPath = context.getRequestDispatcher("/login.jsp");
	    	
	    	// request와 response를 포워딩(전송) // 부탁, 요청 역할
	    	loginPath.forward(request, response); 
	    	
			System.out.println("로그인 해주세요.");
			
		}
		
	}
	

}
