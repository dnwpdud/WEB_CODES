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

// TODO : memberUpdate.jsp에서 전송된 데이터로 DB 회원 정보 수정
// 		  회원 정보 수정에 성공하면 memberResult.jsp에 MemberVO 데이터 전송하여 출력

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	private static final String CLASSNAME
 	= RegisterServlet.class.getName(); // 클래스 위치와 이름 참조
	
    public UpdateServlet() {
    	dao = MemberDAOImple.getInsttance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()");
		// url로 접근할 경우(GET) 경로 변경
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		
		String userid = (String)session.getAttribute("userid");
		System.out.println(userid);
		if(userid != null) {
			
			String emailAgree = request.getParameter("emailAgree");
			if(emailAgree == null) {
				emailAgree = "no";
			} 
			MemberVO vo = new MemberVO();
			
			// 입력된 값을 가져와서 오류났음 저장된 값을 가져와야 하는데
			String password = request.getParameter("password");
		    String email = request.getParameter("email");
		    String[] interest = request.getParameterValues("interest");
		    String phone = request.getParameter("phone");
		    String introduce = request.getParameter("introduce");
		    
		    vo = new MemberVO(userid, password, email, emailAgree
					, interest, phone, introduce);
		   
			
			int result = dao.update(userid, vo);
			if(result == 1) {
				MemberVO member = vo;
				
				request.setAttribute("member", member);
				
				ServletContext context = getServletContext();
				
				// 클라이언트로부터 발생된 요청을 다른 결로의 리소스(Servlet or jsp)로 전송 하는역할
		    	RequestDispatcher memberResult = context.getRequestDispatcher("/memberResult.jsp");
		    	
		    	// request와 response를 포워딩(전송) // 부탁, 요청 역할
		    	memberResult.forward(request, response); 
			} else {
				System.out.println("실패");
			}

		} else {
			// url로 접근할 경우(GET) 경로 변경
			response.sendRedirect("login.jsp");
			
			System.out.println("로그인 해주세요.");
		}
	}
}
