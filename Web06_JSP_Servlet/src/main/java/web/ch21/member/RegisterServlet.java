package web.ch21.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	
    public RegisterServlet() {
    	dao = MemberDAOImple.getInsttance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect() : 특정 경로로 이동
		// request는 소멸되기 때문에 데이터를 전송할 수 없음
		
		response.sendRedirect("/Web_JSP_Servlet/ch21/register.jsp");// 리퀘스트만 이동하고 데이터는 안준다. 페이지만 이동
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 파라미터 데이터 가져오기
	    String userid = request.getParameter("userid");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String emailAgree = request.getParameter("emailAgree");
	    String[] interest = request.getParameterValues("interest");
	    String phone = request.getParameter("phone");
	    String introduce = request.getParameter("introduce");
	    
	    // MemberVO 객체 생성하여 파라미터 데이터 저장
	    MemberVO member = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
	    
	    // System.out.println(member); 로그 덕분에 어떤것이 null이들어가고 안들어가는지을 했기때문에 알 수 있었다.
	    int result = dao.insert(member);
	    System.out.println(result);
	    
	}
	
	

}
