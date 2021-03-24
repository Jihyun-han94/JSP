<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>랜덤값 출력</h1>
	<%
	int [] random_arr = (int[])request.getAttribute("random_arr");	

	%>
	<ul>
	<% for (int v: random_arr){ %>
		<li><%=v %></li>
		<%} %>
	</ul>
</body>
</html>