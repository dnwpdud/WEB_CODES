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
		// 쿠키가 배열로 저장되기 때문에 배열로 불어온다.
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){// 쿠키가 null아닐때 출력
			out.print("쿠키값 이름과 값 전체 출력<br>");
			for(Cookie a : cookies){
				out.println("name : " + a.getName() + "<br>");
				out.println("value : " + a.getValue() + "<br>");
				out.println(a.getComment() + "<br>");
			}
		} else {
			out.println("쿠키가 없습니다.");
		}
	%>

</body>
</html>