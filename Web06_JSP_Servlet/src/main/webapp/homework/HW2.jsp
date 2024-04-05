<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%-- 
	1. HW2.jsp 파일
	- 회원 가입 form 만들기
	- POST 방식
	- action="HW2_memberInfo.jsp"
	- 아이디(text): name="userId"
	- 패스워드(password) : name="password"
	- 이메일 (email) : name="email"
	- 이메일 수신여부(radio 버튼) : name="emailAgree"
	- 관심사항type="checkbox" name="interest" value="IT">IT/ 인터넷
		<input (checkbox, 관심사항 4개 이상 설정)
	  ㄴ 예시)
	  	<input type="checkbox" name="interest" value="movie">영화
	- 핸드폰(text) : name="phone"
	- 자기소개(<textarea>) : name="introduce"
	
	2. MemberVO.java 파일
	- src/main/java/edu.web.homework 패키지에 MemberVO.java 클래스 생성
	- (변수 개수와 변수 이름은 form 태그 input name 값과 동일하게 작성)
	- MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
	- String[] interest; (관심사항은 배열로 변수 선언)
	- request.getParameterValues() : checkbox로 선택된 여러 개의 데이터를 저장// HOLD
	
	3. HW2_memberInfo.jsp 파일
	- HW2.jsp에서 전송된 데이터를 출력
	- request.getParameter or request.getParameterValues를
	  사용하지 않고 구현
	- 아래 코드를 추가하면 해결됨
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"/>
	<jsp:setProperty property"*" name="member" />
	- property="*"의 의미 : HW2.jsp에서 넘어온 모든
		parameter 값을 member 객체에 저장
	 --%>
	 
	 <jsp:useBean id="member" class="edu.web.homework.MemberVO"></jsp:useBean>
	 <jsp:setProperty property="*" name="member" />
	 <h1>회원가입 프로그램</h1>
	 <form action="HW2_memberInfo.jsp" method="post">
	 	<p>아이디</p>
	 	<input type="text" name="userId" placeholder="아이디 입력"> 
	 	<p>패스워드</p>
	 	<input type="password" name="passsword" placeholder="패스워드 입력">
	 	<p>이메일</p>
	 	<input type="email" name="email" placeholder="이메일 입력">
	 	<p>이메일 수신여부</p>
	 	<input type="radio" name="emailAgree" value="ok">
	 	<input type="radio" name="emailAgree" value="off">
	 	<p>관심사항</p>
	 	<input type="checkbox" name="interest" value="movie"> 영화
	 	<input type="checkbox" name="interest" value="sports"> 스포츠
	 	<input type="checkbox" name="interest" value="reading"> 독서
	 	<input type="checkbox" name="interest" value="cooking"> 요리
	 	<p>핸드폰</p>
	 	<input type="text" name="phone">
	 	<p>자기소개</p>
	 	<input type="<textarea>" name="introduce">
	 	<br>
	 	<input type="submit" value="가입하기">
	 	 
	 </form>

</body>
</html>