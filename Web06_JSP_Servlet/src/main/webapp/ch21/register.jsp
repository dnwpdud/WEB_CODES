<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입하기</h2>
	<form action="../register.do" method="post">
	
	<label for="userid">아이디:</label>
    <input type="text" id="userid" name="userid" required><br>

    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="emailAgree">이메일 수신 여부:</label>
    <input type="checkbox" id="emailAgree" name="emailAgree" value="agree" required><br>

    <label for="interest">취미:</label><br>
    <input type="checkbox" id="interest1" name="interest" value="서버개발">
    <label for="interest1">서버 개발</label><br>
    <input type="checkbox" id="interest2" name="interest" value="앱 개발">
    <label for="interest2">앱 개발</label><br>
    
    <!-- Add more interest checkboxes as needed -->

    <label for="phone">전화번호:</label>
    <input type="tel" id="phone" name="phone" required><br>

    <label for="introduce">자기소개:</label><br>
    <textarea id="introduce" name="introduce" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="Submit">
	
	</form>
	
	
	
</body>
</html>