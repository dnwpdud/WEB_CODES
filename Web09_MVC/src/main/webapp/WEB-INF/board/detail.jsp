<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js">
</script>
<meta charset="UTF-8">
<title>${vo.boardTitle }</title>
</head>
<body>
   <h2>글 보기</h2>
   <div>
      <p>글 번호 : ${vo.boardId }</p>
   </div>
   <div>
      <p>제목 : </p>
      <p>${vo.boardTitle }</p>
   </div>
   <div>
      <p>작성자 : ${vo.memberId }</p>
      <p>작성일 : ${vo.boardDateCreated }</p>
   </div>
   <div>
      <textarea rows="20" cols="120" readonly>${vo.boardContent }</textarea>
   </div>
   
   <a href="index.jsp"><input type="button" value="글 목록"></a><br>
   
   <c:if test="${empty sessionScope.memberId == vo.memberId}">
   <a href="update.do?boardId=${vo.boardId}">
   <input type="button" value="글 수정"></a>
   <form action="delete.do" method="POST">
      <input type="hidden" id="boardId" name="boardId" value="${vo.boardId }">
      <input type="submit" value="글 삭제">
   </form>	
   </c:if>
   
   <c:if test="${empty sessionScope.memberId }">
   	* 댓글은 로그인이 필요한 서비스입니다.
   	<a href="login.go">로그인하기</a>
   </c:if>
   
    <input type="hidden" id="boardId" name="boardId" value="${vo.boardId }">
   <c:if test="${not empty sessionScope.memberId }">
   	${sessionScope.memberId }님, 이제 댓글을 작성할 수 있어요!<!-- 세션에 있는 데이터 즉 id을 가져와 출력 -->
   	 <div style="text-align: center;"><!-- 내부 택스트을 가운데 정렬 하는 기능 -->
      <input type="text" id="memberId" value="${sessionScope.memberId }" readonly="readonly">
      <input type="text" id="replyContent">
      <button id="btnAdd">작성</button>
   </div>
   </c:if>
   
  
   <hr>
   <div style="text-align: center;">
      <div id="replies"></div>
   </div>
   
   <div>
      <br><br><br><br><br><br><br><br>
   </div>
   
  
   <script type="text/javascript">
      $(document).ready(function(){// 기본적 jsp에서 사용하는 코드
         getAllReplies(); // 함수 호출 코드 추가
         
         // 댓글 등록
         $('#btnAdd').click(function(){
        	console.log('로그')
            let boardId = $('#boardId').val(); // 게시판 번호 데이터
            let memberId = $('#memberId').val(); // 작성자 데이터
            let replyContent = $('#replyContent').val(); // 댓글 내용
            let obj = {
                  'boardId' : boardId,
                  'memberId' : memberId,
                  'replyContent' : replyContent
            };
            console.log(obj); // 로그
            
            // $.ajax로 송수신
            $.ajax({
               type : 'POST', 
               url : 'replies/add', 
               data : {'obj' : JSON.stringify(obj)}, // JSON으로 변환
               success : function(result) {
                  console.log(result);
                  if(result == 'success'){
                	  alert('댓글 입력 성공');
                	  getAllReplies();// 전체검색 메소드
                  }
               }
            }); // end ajax()
         }); // end btnAdd.click()
         
         
         // 게시판 댓글 전체 가져오기
         function getAllReplies() {
            // 댓글을 가져오기 위해 boardId 필요
            let boardId = $('#boardId').val(); // HTML에 있는 boardId을 저장
            //  $('#boardId') : HTML에 id=boardId 선택 // val() : 선택한 거에 value을 가져오는 역할
            
            // url에 boardId 전송
            let url = 'replies/all?boardId=' + boardId; 
            
            // 가져올 데이터가 JSON이므로
            // getJSON으로 파싱하는게 편리함
            $.getJSON( // JSON 데이터 가져오는 역할 인뜻
               url, 
               function(data) {
                  // data : 서버에서 전송받은 list 데이터가 저장되어 있음.
                  // getJSON()에서 json 데이터는
                  // javascript object로 자동 parsing됨
                  console.log(data); // DB에 저장 된 list 값
               
               	  let list = ''; // 댓글 데이터를 HTML에 표현할 문자열 변수
               	  // $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
               	  $(data).each(function() {
						// this : 컬렉션의 각 인덱스 데이터를 의미
						console.log(this);// 각각 데이터을 출력
               	  		
               	  		// string을 date 타입으로 변경
               	  		let replyDateCreated = new Date(this.replyDateCreated)
						//let memberId = this.memberId
						let memberId = $('#memberId').val(); // 작성자 데이터
						let disabled = '';
						let readonly = '';
						
						if(memberId != this.memberId){
							disabled = 'disabled';
							readonly = 'readonly';
						} // 위 에랑 위치 바뀌어도 됨
						
               	  		//console.log(sessionScope.memberId)
               	  	 list += '<div class="reply_item">'
                         + '<pre>'
                         + '<input type="hidden" id="replyId" value="' + this.replyId + '">'
                         + this.memberId
                         
                         + '&nbsp;&nbsp;' // 공백
                         + '<input type="text" id="replyContent" '+ readonly + ' value="' + this.replyContent + '">'
                         + '&nbsp;&nbsp;' // 공백
                         + replyDateCreated 
                         + '&nbsp;&nbsp;' // 공백
     					 + '<button class="btn_update"'+ disabled +'>수정</button>'
                         + '<button class="btn_delete"'+ disabled +'>삭제</button>'
                         + '</pre>'
                         + '</div>';
                         
                       
                   
            }); // end each()
					$('#replies').html(list);
               }
            ); // end getJSON
            
         } // end getAllReplies()
         
         
         // 댓글 수정
         
         $('#replies').on('click', '.reply_item .btn_update', function() {
			console.log(this);
			// this에 클릭한 요소 정보가 저장되어 있습니다.
			
			// 선택된 댓글의 replyId, replyContent 값을 저장
			// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
			
			let replyId = $(this).prevAll('#replyId').val();
			let replyContent = $(this).prevAll('#replyContent').val();
			console.log("선택된 댓글 번호 : " + replyId + ", 댓글 내용 : " + replyContent);
			
			// ajax로 데이터 전송하여
			// 댓글 수정 기능 수행하고
			// 수행 결과를 리턴하는 코드
			// ajax 요청
			$.ajax({
				type : 'POST',
				url : 'replies/update',
				data : {
					'replyId' : replyId,
					'replyContent' : replyContent
				}, 
				success : function(result) {
					console.log(result);
					if(result == 'success'){
	                	  alert('댓글 입력 성공');
	                	  getAllReplies();
	                  }
				}
			}); // end ajax()
		}); // end replies()
      
   // 댓글 삭제
      $('#replies').on('click', '.reply_item .btn_delete', function() {
			console.log(this);
			// this에 클릭한 요소 정보가 저장되어 있습니다.
			
			// 선택된 댓글의 replyId, replyContent 값을 저장
			// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
			
			let replyId = $(this).prevAll('#replyId').val();
			console.log("선택된 댓글 번호 : " + replyId);
			
			// ajax로 데이터 전송하여
			// 댓글 삭제 기능 수행하고
			// 수행 결과를 리턴하는 코드
			// ajax 요청
			$.ajax({
				type : 'POST',
				url : 'replies/delete',
				data : {
					'replyId' : replyId,
				}, 
				success : function(result) {
					console.log(result);
					if(result == 'success'){
	                	  alert('댓글 삭제 성공');
	                	  getAllReplies();
	                  }
				}
			}); // end ajax()
		}); // end replies.on(delete)()
   }); // end document 
   </script>

</body>
</html>









