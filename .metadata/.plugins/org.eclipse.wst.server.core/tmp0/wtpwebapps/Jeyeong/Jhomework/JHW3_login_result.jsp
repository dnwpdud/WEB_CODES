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
		String id = (String)session.getAttribute("id");
		
		System.out.print(id);
		if(id != null){
			out.print("<h2>"+ id + "님 환영합니다.</h2>");
		} else {
			out.print("<script>alert('로그인 해주세요!')</script>");
			out.print("<script>location.href='JHW3.jsp'</script>");
		}
	%>
	<form action="JHW3.jsp">
	<input type="submit" name = "logout" value="로그아웃">
	</form>

</body>
</html>