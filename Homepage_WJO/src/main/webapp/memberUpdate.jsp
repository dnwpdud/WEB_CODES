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
	
	String userid = (String) session.getAttribute("userid");
	
	if(userid != null){
		out.println("<h2>"+ userid +"님, 수정 페이지.</h2>");
	} else {
		out.print("<script>alert('로그인 해주세요!!')</script>");
		out.print("<script>location.href='login.jsp'</script><br>");
	}
		// TODO : 로그인된 사용자 아이디를 저장
		// TODO : form action="update.do" method="post" 생성
		// TODO : userid를 제외한 모든 정보 수정 가능하게 input 태그 작성
		// 		  userid는 읽기만 가능하도록 input 태그 생성
		
		// 회원 정보등록 할 때와 같은 태그 전부 가져오면 될 뜻
	%>
	
	<h2>회원 정보 수정</h2>
	<form action="update.do" method="post">
	
	아이디<br>
    <input type="text"name="userid" value="<%=userid %>" readonly="readonly"><br>
	
    비밀번호<br>
    <input type="password"  name="password" required><br>

    이메일<br>
    <input type="email" name="email" required><br>

    이메일 수신 여부
    <input type="checkbox"  name="emailAgree" value="agree"><br>

    취미<br>
    <input type="checkbox"  name="interest" value="서버개발">
    서버 개발<br>
    <input type="checkbox" name="interest" value="앱 개발">
    앱 개발<br>

    전화번호<br>
    <input type="tel" name="phone" required><br>

    자기소개<br>
    <textarea name="introduce" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="수정">
	
	</form>
	
	<form action="memberResult.jsp" method="post">
	<input type='submit' value='뒤로가기'><br>
	</form>

</body>
</html>