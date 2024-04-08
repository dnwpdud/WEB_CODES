<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	전송된 데이터가 
	만약 'a'로 시작하면 "apple"
		'b'로 시작하면 "banana"
		'c'로 시작하면 "coconut"
	그게 아니면 "not fruits"를 출력해라!
--%>
<%
	String str = request.getParameter("str");// 앞쪽에서 입력한 데이터가 request로 저장이 되어서 여기서 꺼낼수 있다. 
	// 그리고 자바스크립을 할때는 Parameter 사용하라고 조언 해주심??
	System.out.println(str);
	out.write("");// 로그
	
	String result; // 상황에 맞게 저장
	
	if(str.charAt(0) == 'a'){ // 조건에 맞게 출력
		result = "apple";
	} else if(str.charAt(0) == 'b'){
		result = "banana";
	} else if(str.charAt(0) == 'c'){
		result = "coconut";
	} else {
		result = "not fruits";
	}
	
%>

<%=result %>