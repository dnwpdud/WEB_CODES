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
	// 한글 인코딩Attribute
	request.setCharacterEncoding("UTF-8");

	session.setMaxInactiveInterval(10);
	
	// 브라우저에서 입력된 값 가져오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("test") && pw.equals("1234")){
		session.setAttribute("id", id); // 세션 생성

		
		out.print("<script>alert('세션 생성 완료')</script>");
		out.print("<script>location.href='JHW3_login_result.jsp'</script>");
	} else {
		out.print("<script>alert('아이디와 비밀번호을 확인해 주세요.')</script>");
		out.print("<script>location.href='JHW3.jsp'</script>");
	}
	
	

%>

</body>
</html>