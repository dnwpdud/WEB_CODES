<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
    <form action="register.do" method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="boardTitle"><br>
        <label for="author">작성자:</label>
        <input type="text" id="author" name="boardContent"><br>
        <label for="content">내용:</label><br>
        <textarea id="content" name="memberId" rows="4" cols="50"></textarea><br>
        <button type="submit">등록</button>
    </form>
</body>
</html>
