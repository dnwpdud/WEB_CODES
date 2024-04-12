<%@ page import="edu.web.domain.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board Information</title>
</head>
<body>
    <%
    	//request.setCharacterEncoding("UTF-8");
        List<BoardVO> voList = (List<BoardVO>) request.getAttribute("vo");
    %>

    <table border="1">
        <thead>
            <tr>
                <th>게시물 번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <% for (BoardVO vo : voList) { %>
                <tr>
                    <td><%= vo.getBoardId() %></td>
                    <td>  <a href="detail.do?boardId=<%= vo.getBoardId() %>"><%= vo.getBoardTitle() %></a></td>
                    <td><%= vo.getMemberId() %></td>
                    <td><%= vo.getBoardDateCreated() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
     <button onclick="location.href='register.do'">글 등록</button>

</body>
</html>
