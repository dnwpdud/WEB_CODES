<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="03_parameter.jsp" method="post">
	
	아이디<br>
    <input type="text" id="userid" name="userid" required><br>

    비밀번호<br>
    <input type="password" id="password" name="password" required><br>

    이메일<br>
    <input type="email" id="email" name="email" required><br>

    이메일 수신 여부
    <input type="checkbox" id="emailAgree" name="emailAgree" value="agree"><br>

    취미<br>
    <input type="checkbox" id="interest1" name="interest" value="서버개발">
    서버 개발<br>
    <input type="checkbox" id="interest2" name="interest" value="앱 개발">
    앱 개발<br>

    전화번호<br>
    <input type="tel" id="phone" name="phone" required><br>

    자기소개<br>
    <textarea id="introduce" name="introduce" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="회원가입">
	
	</form>

</body>
</html>