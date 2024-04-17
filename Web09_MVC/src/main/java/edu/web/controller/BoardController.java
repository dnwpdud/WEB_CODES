package edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.domain.BoardVO;
import edu.web.persistence.BoardDAO;
import edu.web.persistence.BoardDAOImple;
import edu.web.util.PageCriteria;
import edu.web.util.PageMaker;

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
	private static final String LOGIN = "login";
	
	private static BoardDAO dao;
	
    public BoardController() {
    	dao = BoardDAOImple.getInstance();
    }
    

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	//request.setCharacterEncoding("UTF-8");
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

//		List<BoardVO> vo = dao.select(); // 전 전체 리스트 검색하는 코드 
		
		String page = request.getParameter("page");
		System.out.println(page); // null 나옴 위에 코드 왜 있지?? 그냥 예외 처리 장치인뜻
		
		PageCriteria criteria = new PageCriteria();// vo에 등록된 시작과 끝 페이지 정했던 값을 가져오기위해 인스턴스 한 뜻
		
		if(page != null) { // null이 아니면 Parameter로 불러온 값을 int로 형 변환 // 그냥 예외 처리 장치 인뜻
			criteria.setPage(Integer.parseInt(page));
			System.out.println(criteria);
		}
		
		List<BoardVO> vo = dao.select(criteria);
		
		String path = BOARD_URL + LIST + EXTENSION; // 페이지 이동 // 이런 방식으로 하면는 jsp 경로을 숨길수 있다. 그렇기 떄문에 무조건 서브릿을 거친다.
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(path);
		
		request.setAttribute("vo", vo); // 객체형태로 데이터 보내는 대적인 예시 // 왜 이게 여기 위치이지??
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = dao.getTotalCount(); // 페이지의 총개수 
		pageMaker.setTotalCount(totalCount);  // 페이지 총개수 vo TotalCount 변수에 저장
		pageMaker.setPageData(); // 시간 저장
		System.out.println("전체 게시글 수 : " + pageMaker.getTotalCount());
		System.out.println("현재 선택된 페이지 : " + criteria.getPage());
		System.out.println("한 페이지당 게시글 수 : " 
				+ criteria.getNumsPerPage());
		System.out.println("페이지 링크 번호 개수 : "
				+ pageMaker.getNumsOfPageLinks());
		System.out.println("시작 페이지 링크 번호 : " 
				+ pageMaker.getStartPageNo());
		System.out.println("끝 페이지 링크 번호 :"
				+ pageMaker.getEndPageNo());
		
		System.out.println(pageMaker);
		request.setAttribute("pageMaker", pageMaker);
		
		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
		
	} // end list()
	
	// TODO : register.jsp 페이지 호출 // GET은 그냥 페이지을 이동하는 역할일뿐이다.
	private void registerGET(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("registerGET");
		
		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("memberId");
		
		if(memberId == null){
			System.out.println("로그인 해주세요");
			response.sendRedirect(BOARD_URL + LOGIN + EXTENSION);
			//response.sendRedirect("/board/login.jsp");
		}

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

		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String memberId = request.getParameter("memberId");
		
		System.out.println(memberId);
		
		BoardVO vo = new BoardVO(0, boardTitle, boardContent, memberId, null);
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println("결과 : " + result); // 잘 실행된는지 확인 // 이거 안했음 까먹었음 값이 바뀔때만다. 로그을 작성하는 해야한다.
		
		//registerGET(request, response);
		
		if(result == 1) { // 합번더 조건에 맞게 처리해서 오류 상황을 최대한 없애다.
			response.sendRedirect(MAIN + EXTENSION);
		}
		

	}// end registerPOST() 
	
	// TODO : DB 테이블에서 상세 조회 데이터를 가져와서 , detail.jsp 페이지로 전송
	private void detail(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ // 클라이언트에서 무엇 조야함??

		System.out.println("detail()");
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		//List<BoardVO> vo = (List<BoardVO>) dao.select(boardId);
		System.out.println(boardId);
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
		System.out.println(request.getParameter("boardId"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		BoardVO vo = dao.select(boardId);
		
		String path = BOARD_URL + UPDATE + EXTENSION; // 페이지 이동
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(path);// 그냥 데이터 전송할때 이거 다음에 전송할 코드 놓자 궁금하면 나중에 알아보기
		
		request.setAttribute("vo", vo);
		
		
		dispatcher.forward(request, response); // jsp 경로을 우회적으로 불러오는 기능
		
	} // end updateGET()
	
	// TODO : update.jsp에서 전송된 수정할 데이터를 DB로 전송하여 테이블 수정 수행
	// TODO : 수정이 완료되면, detail.jsp로 이동(이동할 때 어떤 값을 전송해야 할 지 생각) 
	private void updatePOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("updatePOST()");

		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		BoardVO vo = new BoardVO(boardId, boardTitle, boardContent, null, null);
	
		int result = dao.update(vo);
		System.out.println(result);
		
//		BoardVO voSelect = (BoardVO) dao.select(boardId); // 여기서 jsp로 가는것이 아니라 서브릿으로 갔으면은 보안도 좋아지고
		// 구지 vo내용 전체을 전송할 필요도 없어 효율적이다.

		//detail(request, response);
		
		if(result == 1) {
			String path = DETAIL + SERVER_EXTENSION; // 페이지 이동
			
			response.sendRedirect(path + "?boardId=" + boardId);// j쿼리을 사용해서 이동하는것을 생각도 못했고 어렵고 내가 아직 잘 못 한다.
		}
		
		
	}// end updatePOST()
	
	// TODO : 게시글 번호를 전송받아서, DB 테이블에서 데이터 삭제
	// TODO : 삭제가 완료되면, index.jsp로 이동
	private void deletePOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("deletePOST()");
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		int result = dao.delete(boardId);
		
		if(result == 1) {
			response.sendRedirect(MAIN + EXTENSION);
		}
		
	}// end deletePOST()

} // end 
