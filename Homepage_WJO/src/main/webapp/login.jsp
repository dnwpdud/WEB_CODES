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
		// TODO : <a> 태그를 이용하여 memberRegister.jsp 이동 링크 생성
		// TODO : 로그인 form 생성. action="loginAuth.do" method="post"
		request.setCharacterEncoding("UTF-8");
	%>
	
	<form action="loginAuth.do" method="post">
	<h2>로그인</h2>
	아이디<br>
    <input type="text" name="userid" required><br>

    비밀번호<br>
    <input type="password" name="password" required><br>
	
	<input type="submit" value="로그인">
	</form>
	
	<!-- <a href="memberRegister.jsp" target="_self">회원가입 링크</a> -->
	<a href="memberRegister.jsp">회원가입 링크</a>
	
</body>
</html>