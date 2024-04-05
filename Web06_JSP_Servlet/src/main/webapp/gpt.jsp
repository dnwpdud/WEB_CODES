<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>

<%
    // "username" 매개변수에 대한 값을 가져옴
    String[] usernames = request.getParameterValues("username");
    
    // "password" 매개변수에 대한 값을 가져옴
    String[] passwords = request.getParameterValues("password");
%>

<html>
<head>
    <title>Parameter Values</title>
</head>
<body>
    <h1>Username Values:</h1>
    <p><%= Arrays.stream(usernames).collect(Collectors.joining(", ")) %></p>
    
    <h1>Password Values:</h1>
    <p><%= Arrays.stream(passwords).collect(Collectors.joining(", ")) %></p>
</body>
</html>
