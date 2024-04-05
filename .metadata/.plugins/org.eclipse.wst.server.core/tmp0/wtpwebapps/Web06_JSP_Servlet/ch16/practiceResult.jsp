<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>

	 
<%
	
	// practiceLogin.jsp에서 saveAgreed가 체크가 되어 있으면
	// id, pw에 대한 쿠키를 생성한다.
	// 쿠키 만료 시간은 10분으로 설정
	
	// 한국어 인코딩
	request.setCharacterEncoding("UTF-8");
	
	// input 입력된 요소들을 가져와서 변수에 저장
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String saveAgreed = request.getParameter("saveAgreed");
	
	// 각 쿠키 변수에 input된 변수 값을 저장
	Cookie idNameCookie = new Cookie("id", id);
	Cookie pwNameCookie = new Cookie("pw", pw);
	Cookie saveAgreedCookie = new Cookie("saveAgreed", saveAgreed);
	
	if(saveAgreed != null){// 체크여부에 따라 출력 결과가 달라 조건에 맞게 판별 할 수 있다.
		// 쿠키에 저장된는 시간설정
		idNameCookie.setMaxAge(60 * 10);
		pwNameCookie.setMaxAge(60 * 10);
		saveAgreedCookie.setMaxAge(60 * 10);
		
		// 브라우저에 쿠키을 추가하는 기능
		response.addCookie(idNameCookie);
		response.addCookie(pwNameCookie);
		response.addCookie(saveAgreedCookie);
	} else {
		System.out.println("실패");
	}
	
	
%>
	<h2>로그인 결과 화면</h2>
	<p><%=request.getParameter("id") %></p>
	
</body>
</html>