<%@ page import="edu.web.domain.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
   border-style : solid;
   border-width : 1px;
   text-align : center;
}

ul {
   list-style-type : none;
}

li {
   display : inline-block;
}
</style>
    <meta charset="UTF-8">
    <title>Board Information</title>
</head>
<body>
	<h1>게시판 메인</h1>
	<button onclick="location.href='register.do'">글 등록</button>
	<hr>
    <%
    	//request.setCharacterEncoding("UTF-8");
        List<BoardVO> voList = (List<BoardVO>) request.getAttribute("vo");
    %>

    <table>
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
                    <td><a href="detail.do?boardId=<%= vo.getBoardId() %>"><%= vo.getBoardTitle() %></a></td>
                    <td><%= vo.getMemberId() %></td>
                    <td><%= vo.getBoardDateCreated() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
    <ul>
    	<c:if test="${pageMaker.hasPrev }"> <!-- 이전이 있는지 없는지 -->
    		<li><a href="list.do?page=${pageMaker.startPageNo - 1}">이전</a></li>
    	</c:if>
    	
    	<!-- 여긴 1 ~ 5까지 페이지 표현하는 역할 -->
    	<c:forEach begin="${pageMaker.startPageNo}" end="${pageMaker.endPageNo}"
    	 var="num">
   		 <li><a href="list.do?page=${num}">${num}</a></li>
		</c:forEach>
		
		<c:if test="${pageMaker.hasNext }"> <!-- 이후가 있는지 없는지 -->
			<li><a href="list.do?page=${pageMaker.endPageNo + 1} ">다음</a></li>
		</c:if>
    </ul>
    
    

</body>
</html>
