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
	String email = (String)request.getAttribute("email");
	%>
	<h1>회원가입 완료!</h1>
	<label>아이디 : <%=id%></label>
	<label>이메일 : <%=email %></label>

</body>
</html>