<%@page import="edu.web.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
</head>
<body>
    <% 
    request.setCharacterEncoding("UTF-8");
    BoardVO vo = (BoardVO) request.getAttribute("vo"); 
    %>
    <ul>
        <li>
            <strong>게시물 번호:</strong> <%= vo.getBoardId() %><br>
            <strong>제목:</strong> <%= vo.getBoardTitle() %><br>
            <strong>작성자:</strong> <%= vo.getMemberId() %><br>
            <strong>작성일:</strong> <%= vo.getBoardDateCreated() %><br>
            <strong>내용:</strong> <%= vo.getBoardContent() %><br>
        </li>
    </ul>
    
 	<form action="delete.do" method="post">
    <!-- 숨은 입력 필드에 게시물 ID를 저장 -->
    <input type="hidden" name="delete" value="<%= vo.getBoardId() %>">
    <!-- 삭제 버튼 -->
    <button type="submit">글 삭제</button>
	</form>
    
    <!-- 수정 버튼 -->
    <button onclick="location.href='update.do?update=<%= vo.getBoardId() %>'">글 수정</button>
    
    <!-- 돌아가기 버튼 -->
    <button onclick="location.href='list.do'">돌아가기</button>
</body>
</html>
