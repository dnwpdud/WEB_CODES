<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h2>로그인</h2>
<form action="login.go" method="post">
    <div>
        아이디:
        <input type="text" id="memberId" name="memberId" required>
    </div>
    <div>
        비밀번호:
        <input type="password" id="password" name="password" required>
        <input type="hidden" name="targetURL" value="${targetURL }">
    </div>
    <button type="submit">로그인</button>
</form>

</body>
</html>
