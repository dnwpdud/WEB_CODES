<%@page import="edu.web.domain.BoardVO"%>
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
	 	request.setCharacterEncoding("UTF-8");
	 	BoardVO vo = (BoardVO) request.getAttribute("vo"); 
	 %>
	 
    <form action="update.do" method="post">
        <label for="id">게시물 번호:</label><br>
		<input type="text" id="id" name="boardId" value="<%= vo.getBoardId() %>" readonly><br>
        <label for="title">제목:</label><br>
        <input type="text" id="title" name="boardTitle" value="<%= vo.getBoardTitle() %>"><br>
        <label for="content">내용:</label><br>
        <textarea id="content" name="boardContent"><%= vo.getBoardContent() %></textarea><br>
        <button type="submit">게시물 수정</button>
    </form>
    	 
</body>
</html>