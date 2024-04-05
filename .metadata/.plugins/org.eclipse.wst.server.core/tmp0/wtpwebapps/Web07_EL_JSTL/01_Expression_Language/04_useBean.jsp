<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL useBean</title>
</head>
<body>
	<jsp:useBean id="point" class="edu.web.el01.Point" />
	<jsp:setProperty property="x" name="point" value="1.2"/>
	<jsp:setProperty property="y" name="point" value="3.5"/>
	<p>point의 x, y 좌표값 : ${point.x }, ${point.y }</p>
	<p>point의 x, y 좌표값 : ${pageScope.point.x }, ${pageScope.point.y }</p>
	<!-- 여기 코드 잘모르겠음 -->
	
	<%-- el 메소드 표기 --%>
	<p>좌표 거리 : ${point.distance(1, 2) }</p>
	<p>좌표 출력 : ${point.toString() }</p>
</body>
</html>