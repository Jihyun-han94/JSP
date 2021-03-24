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
	String id = (String)request.getAttribute("id");
	String password = (String)request.getAttribute("password");
	
	%>
	<h1>환영합니다! <%=id %> 님!</h1>
	
	
</body>
</html>