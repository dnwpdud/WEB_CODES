<%@page import="edu.web.member.MemberDAO"%>
<%@page import="edu.web.member.MemberVO"%>
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
		// TODO : 회원 정보 출력
		// TODO : 회원 수정 버튼 생성(경로 : memberUpdate.jsp)
		// TODO : 회원 탈퇴 버튼 생성(경로 : delete.do)
		
		request.setCharacterEncoding("UTF-8");
	
		String userid = (String) session.getAttribute("userid");
		MemberVO vo = (MemberVO)request.getAttribute("vo");// 이거 문제가 심함
		/*if(userid != null){ // 조건안에 vo가 들어가 있으면 HTML에서 인식을 못하여 작성 자체가 안된다.
			// 근데 논리적으로는 동작이 되면서 vo가 생기기때문에 그렇게 생각한거 같다.
			
			out.println("<h2>"+ userid +"님, 정보 입니다.</h2>");
			
			vo = (MemberVO)request.getAttribute("vo");// 이거 문제가 심함
			System.out.println("뷰");
			System.out.println(vo);
			
		} else {
			out.print("<script>alert('로그인 해주세요!!')</script>");
			out.print("<script>location.href='login.jsp'</script><br>");
		}*/
	%>
	
	<p>아이디 : <%=vo.getUserid() %></p>
	<p>비밀번호 : <%=vo.getPassword() %></p>
	<p>이메일 : <%=vo.getEmail() %></p>
	<p>이메일 수신여부 : <%=vo.getEmailAgree() %></p>
	<p>관심사항 : </p>
	<p><%=vo.getInterestJoin() %></p>
	<p>핸드폰 : <%=vo.getPhone() %></p>
	<p>자기소개</p>
	<%=vo.getIntroduce() %><br>
	
	<form action="memberUpdate.jsp" method="post">
	<input type="submit" value="회원수정">
	</form>
	
	<form action="delete.do" method="post">
	<input type="submit" value="회원탈퇴">
	</form>
	
	<form action="loginResult.jsp" method="post">
	<input type='submit' value='뒤로가기'><br>
	</form>
	
	<!-- 장식용 doget 방식 구현은 따로 안해놓음 -->
	<button onclick="location.href='memberUpdate.jsp'">회원 정보 수정</button>
	<button onclick="location.href='delete.do'">회원 정보 탈퇴</button>
	<!-- <button onclick="location.href='delete.do'"> 방식대로 가면 Servlet의 get으로 간다. -->
	
</body>
</html>