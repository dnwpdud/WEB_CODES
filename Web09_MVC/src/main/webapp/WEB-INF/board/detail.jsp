<%@page import="edu.web.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js">
</script>
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
    <input type="hidden" id="boardId" name="boardId" value="<%= vo.getBoardId() %>">
    <!-- 삭제 버튼 -->
    <button type="submit">글 삭제</button>
	</form>
	
	  <!-- 수정 버튼 -->
    <button onclick="location.href='update.do?update=<%= vo.getBoardId() %>'">글 수정</button>
    
    <!-- 돌아가기 버튼 -->
    <button onclick="location.href='index.jsp'">돌아가기</button>
    
	<div style="text-align: center;">
		<input type="text" id="memberId">
		<input type="text" id="replyContent">
		<button id ="btnAdd">작성</button>
	</div>
	<hr>
	<div style="text-align: center;">
		<div id="replies"></div>
	</div>
	
	<div>
		<br><br><br><br><br><br><br><br>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function () {
		$('#btnAdd').click(function () {
			let boardId = $('#boardId').val(); // 게시판 번호 데이터
			let memberId = $('#memberId').val(); // 작성자 데이터
			let replyContent = $('#replyContent').val(); // 댓글 내용
			let obj = {
					'boardId' : boardId,
					'memberId' : memberId,
					'replyContent' : replyContent
					
			}; 
			console.log(obj);
			
			// $.ajax로 송수신
			$.ajax({
				type : 'POST',
				url : 'replie/add',
				data : {'obj' : JSON.stringify(obj)}, // JSON으로 변환 // obj이름
				success : function(result){
					console.log(result);
				}
			});
		}); // end btnAdd
	});// end document
</script>


  
</body>
</html>
