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
		// TODO : 세션을 이용 "userid님, 환영합니다." 라고 화면에 출력
		
		// TODO : 회원 정보 보기 버튼 생성
		// TODO : 로그아웃 버튼 생성
	request.setCharacterEncoding("UTF-8");
	// 강사님 코드는 필터을 통해 모든 객체에 한국어 인코딩과, 세션이 없으면 동작이 안되게 만들어놓아
	// 코드가 더 갈략하게 되어있다. 
	String userid = (String) session.getAttribute("userid");
	
	if(userid != null){
		out.println("<h2>"+ userid +"님, 환영합니다.</h2>");
	} else {
		out.print("<script>alert('로그인 해주세요!!')</script>");
		out.print("<script>location.href='login.jsp'</script><br>");
	}
	
	%>
	
	<!-- location.href로 이동하면 servlet에서 doGet()을 호출
		 ㄴ GET방식으로 동작
	 -->
	<button onclick="location.href='select.do'">회원정보</button>
	<button onclick="location.href='logout.do'">로그아웃</button>
	
	
</body>
</html>