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
		// TODO : 회원 가입 form 생성. action="register.do" method="post"
		request.setCharacterEncoding("UTF-8");
	
	%>
	
	<h2>회원 가입하기</h2>
	<form action="register.do" method="post">
	
	아이디<br>
    <input type="text" name="userid" required><br>

    비밀번호<br>
    <input type="password" name="password" required><br>

    이메일<br>
    <input type="email" name="email" required><br>

    이메일 수신 여부
    <input type="checkbox" name="emailAgree" value="agree"><br>

    취미<br>
    <input type="checkbox" name="interest" value="서버개발">
    서버 개발<br>
    <input type="checkbox" name="interest" value="앱 개발">
    앱 개발<br>

    전화번호<br>
    <input type="tel" name="phone" required><br>

    자기소개<br>
    <textarea name="introduce" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="회원가입">
	
	</form>
	
</body>
</html>