<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 가져오기(GET)</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		if(cookies != null){// 쿠키가 존재하는 경우
			// out.print에 Systime가 빠져 있어 클라이머트로 출력 만약 있으면 
			// 자바 로그창에 출력 
			out.print("<h2>모든 쿠키의 이름과 값 찾기</h2>");
			for(Cookie cookie : cookies){
				out.println("name : " + cookie.getName() + "<br>");
				out.println("value : " + cookie.getValue() + "<br>");
				out.println(cookie.getComment() + "<br>");
			}
		} else {
			out.println("<h2> 쿠키를 찾지 못했습니다.</h2>");
		}
	%>

</body>
</html>