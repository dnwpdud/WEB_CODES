package edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.domain.BoardVO;
import edu.web.persistence.BoardDAO;
import edu.web.persistence.BoardDAOImple;

@WebServlet("*.do") // *.do : ~.do로 선언된 HTTP 호출에 대해 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String MAIN = "index";
	private static final String LIST = "list";
	private static final String REGISTER = "register";
	private static final String UPDATE = "update";
	private static final String DETAIL = "detail";
	private static final String DELETE = "delete";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";
	
	
	private static BoardDAO dao;
	
    public BoardController() {
    	dao = BoardDAOImple.getInstance();
    }
    

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		System.out.println("호출 경로 : " + requestURI); // 여기 접속한 경로 이름
		System.out.println("호출 방식 : " + requestMethod); // 접속 방식
		
		if(requestURI.contains(LIST + SERVER_EXTENSION)) {// contains 포함되어 있으면
			System.out.println("list 호출 확인");
			list(request, response);
		} else if(requestURI.contains(REGISTER + SERVER_EXTENSION)) { 
			System.out.println("register 호출 확인");
			if(requestMethod.equals("GET")) { // GET 방식(페이지 불러오기)
				registerGET(request, response);
			} else if(requestMethod.equals("POST")) { // POST 방식(DB에 저장)
				registerPOST(request, response);
			}
		} else if(requestURI.contains(DETAIL + SERVER_EXTENSION)) {
			System.out.println("detail 호출 확인");
			detail(request, response);
		} else if(requestURI.contains(UPDATE + SERVER_EXTENSION)) {
			System.out.println("update 호출 확인");
			if(requestMethod.equals("GET")) {
				updateGET(request, response);
			} else if(requestMethod.equals("POST")) {
				updatePOST(request, response);
			}
		} else if(requestURI.contains(DELETE + SERVER_EXTENSION)) {
			System.out.println("delete 호출 확인");
			if(requestMethod.equals("POST")) {
				deletePOST(request, response);
			}
		}
    } // end service()

	// TODO : 전체 게시판 내용(list)을 DB에서 가져오고, 그 데이터를 list.jsp 페이지에 전송
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("list()");

		List<BoardVO> vo = dao.select();
		
		request.setAttribute("vo", vo);
		
		String path = BOARD_URL + LIST + EXTENSION; // 페이지 이동
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
		
	} // end list()
	
	// TODO : register.jsp 페이지 호출 // GET은 그냥 페이지을 이동하는 역할일뿐이다.
	private void registerGET(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("registerGET");

		String path = BOARD_URL + REGISTER + EXTENSION; // 페이지 이동
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(path);

		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
		
		
//		response.sendRedirect(BOARD_URL + REGISTER + EXTENSION);
		
	}// end registerGET()
	
	// TODO : register.jsp form에서 전송된 데이터를 DB 테이블에 등록
	// TODO : index.jsp로 이동은 form호출, 이것은 이동, 그래서 여기는 디스페서을 사용하면 안된다.?
	private void registerPOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("registerPOST()");

		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		String memberId = request.getParameter("author");
		System.out.println(memberId);
		
		BoardVO vo = new BoardVO(0, boardTitle, boardContent, memberId, null);
		
		dao.insert(vo);
		
		//registerGET(request, response);
		
		response.sendRedirect(MAIN + EXTENSION);

	}// end registerPOST() 
	
	// TODO : DB 테이블에서 상세 조회 데이터를 가져와서 , detail.jsp 페이지로 전송
	private void detail(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ // 클라이언트에서 무엇 조야함??

		System.out.println("detail()");
		String result = request.getParameter("boardId");
		int boardId = Integer.parseInt(result);
		//List<BoardVO> vo = (List<BoardVO>) dao.select(boardId);
		BoardVO vo = dao.select(boardId);
		
		request.setAttribute("vo", vo);
		
		String path = BOARD_URL + DETAIL + EXTENSION; // 페이지 이동
		

		RequestDispatcher dispatcher
			= request.getRequestDispatcher(path);

		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
		
	} // end detail
	
	// TODO : DB 테이블에서 상세 조회한 게시글 데이터를 전송하고, update.jsp 페이지를 호출
	private void updateGET(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("updateGET()");

		
		String result = request.getParameter("update");
		int boardId = Integer.parseInt(result);
		
		BoardVO vo = dao.select(boardId);
		
		request.setAttribute("vo", vo);
		
		String path = BOARD_URL + UPDATE + EXTENSION; // 페이지 이동
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
		
	} // end updateGET()
	
	// TODO : update.jsp에서 전송된 수정할 데이터를 DB로 전송하여 테이블 수정 수행
	// TODO : 수정이 완료되면, detail.jsp로 이동(이동할 때 어떤 값을 전송해야 할 지 생각) 
	private void updatePOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("updatePOST()");

		
		String result = request.getParameter("id");
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		
		int boardId = Integer.parseInt(result);
		
		BoardVO vo = new BoardVO(boardId, boardTitle, boardContent, null, null);
	
		dao.update(vo);
		
		BoardVO voSelect = (BoardVO) dao.select(boardId);
		
		request.setAttribute("vo", voSelect);
		
		//detail(request, response);
		
		String path = BOARD_URL + DETAIL + EXTENSION; // 페이지 이동
		
		RequestDispatcher dispatcher
		= request.getRequestDispatcher(path);
	
		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
	
		
	}// end updatePOST()
	
	// TODO : 게시글 번호를 전송받아서, DB 테이블에서 데이터 삭제
	// TODO : 삭제가 완료되면, index.jsp로 이동
	private void deletePOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("deletePOST()");
		
		
		String result = request.getParameter("delete");
		System.out.println(result);
		int boardId = Integer.parseInt(result);
		
		dao.delete(boardId);

		
		response.sendRedirect(MAIN + EXTENSION);
	}// end deletePOST()

} // end 
