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
	//한국어 인코딩
	request.setCharacterEncoding("UTF-8");
	
	// 입력된 값 가져오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("test") && pw.equals("1234")){
		// 세션 생성
		session.setAttribute("id", id);
		// 세션 시간(초)
		session.setMaxInactiveInterval(10);
		// 결과 페이지 이동
		out.print("<script>alert('로그인 성공!')</script>");
		out.print("<script>location.href='HW3_login_result.jsp'</script><br>");
	} else {
		// 로그인 페이지 이동 
		out.print("<script>alert('아이디와 비밀번호을 다시 확인해 주세요!')</script>");
		out.print("<script>location.href='HW3.jsp'</script><br>");
	}
%>
	
</body>
</html>