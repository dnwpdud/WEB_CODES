<%@page import="java.util.Enumeration"%>
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
	// 세션 값 가져오기
	String id = (String)session.getAttribute("id");
	
	// 강사님은 id == null로 했음
	if(id != null){ // 세션 값이 있으면 출력
		out.println("<h2>"+ id +"님, 환영합니다.</h2>");
	} else { // 세션 값이 없으면 출력
		out.print("<script>alert('로그인 해주세요!!')</script>");
		out.print("<script>location.href='HW3.jsp'</script><br>");
	}	
	%>
	
	<!-- 로그아웃 클릭시 로그인 창으로 이동 -->
	<form action="HW3.jsp" method="post">
	<input type='submit' name = 'logout' value='로그아웃'><br>
	</form>
	
</body>
</html>