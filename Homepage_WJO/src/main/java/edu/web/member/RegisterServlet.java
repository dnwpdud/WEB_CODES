package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : memberRegister.jsp 에서 전송된 데이터를 DB에 저장
// DB 저장 후에 login.jsp로 이동(심심하면 alert도 띄우기)

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	private static final String CLASSNAME
 	= RegisterServlet.class.getName(); // 클래스 위치와 이름 참조
 
    public RegisterServlet() {
    dao = MemberDAOImple.getInsttance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()");
		// url로 접근할 경우(GET) 경로 변경
		response.sendRedirect("memberRegister.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		 String emailAgree = request.getParameter("emailAgree");
		 
		 //체크가 안되어 있으면 "no" 데이터을 emailAgree변수에 저장
		if(emailAgree == null) {
			emailAgree = "no";
		} 
		
		// 파라미터 데이터 가져오기
	    String userid = request.getParameter("userid");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String[] interest = request.getParameterValues("interest");
	    String phone = request.getParameter("phone");
	    String introduce = request.getParameter("introduce");
	    
	    // MemberVO 객체 생성하여 파라미터 데이터 저장
	    MemberVO member = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
	    
	    System.out.println(member);
	    // System.out.println(member); 로그 덕분에 어떤것이 null이들어가고 안들어가는지을 했기때문에 알 수 있었다.
	    int result = dao.insert(member);
	    
	    // 애플리케이션 정보 제공
	    ServletContext context = getServletContext();
	    
	    if(result == 1) {
	    	// 클라이언트로부터 발생된 요청을 다른 결로의 리소스(Servlet or jsp)로 전송 하는역할
	    	RequestDispatcher loginPath = context.getRequestDispatcher("/login.jsp");
	    	
	    	// request와 response를 포워딩(전송) // 부탁, 요청 역할
	    	loginPath.forward(request, response); 

	    } else {
	    	// 클라이언트로부터 발생된 요청을 다른 결로의 리소스(Servlet or jsp)로 전송 하는역할
	    	RequestDispatcher loginPath = context.getRequestDispatcher("/memberRegister.jsp");
	    	
	    	// request와 response를 포워딩(전송) // 부탁, 요청 역할
	    	loginPath.forward(request, response); 
	    	System.out.println("회원 가입 실패");
	    }
	}

}
