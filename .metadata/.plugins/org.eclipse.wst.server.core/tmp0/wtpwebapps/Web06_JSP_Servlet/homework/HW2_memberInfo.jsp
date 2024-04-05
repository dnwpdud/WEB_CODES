<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW2_memberlngo</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"/>
	<jsp:setProperty name="member" property="*"/>
	<%
		
	%>
	
	<h2>회원 정보</h2>
	<p>아이디 : <%=member.getUserId() %></p>
	<p>비밀번호 : <%=member.getPassword() %></p>
	<p>이메일 : <%=member.getEmail() %></p>
	<p>이메일 수신 여부 : <%=member.getEmailAgree() %></p>
	<p>관심사항 : <%=member.getInterest() %></p>
	<%= member.getInterestJoin()%>
	<p>핸드폰 : <%=member.getPhone() %></p>
	<p>자기소개 : <%=member.getIntroduce() %></p>
</body>
</html>