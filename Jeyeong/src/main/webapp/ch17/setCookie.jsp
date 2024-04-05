<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 한국어 인코딩
	request.setCharacterEncoding("utf-8");

	// 입력값 가져와서 저장
	String a = request.getParameter("a");
	String bc = request.getParameter("bc");
	
	// 파라미터 값으로 쿠키 생성
	Cookie aName = new Cookie("a", a);
	Cookie bcName = new Cookie("bc", bc);
	
	// 쿠키 시간 설정
	aName.setMaxAge(30);
	bcName.setMaxAge(30);
	
	// 리스팬치을 통해 서번에서 생성된 쿠키을 클라이언트로 전송
	response.addCookie(aName);
	response.addCookie(bcName);
	
	out.println("<h2>전송 완료</h2>");
%>

</body>
</html>