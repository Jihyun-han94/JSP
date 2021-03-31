<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
    href="<%=request.getContextPath() %>/static/bootstrap-4.6.0/css/bootstrap.min.css">
<script type="text/javascript"
    src="<%=request.getContextPath() %>/static/jquery/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
    src="<%=request.getContextPath() %>/static/bootstrap-4.6.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type = "text/css" href="<%=request.getContextPath() %>/main.css">    
</head>
<body>
	
<header>
	<%@ include file="/WEB-INF/module/top_nav.jsp" %>
</header>
	<% 
	if(logined.equals("true")){
	%>
		<h1><%=session.getAttribute("username") %>님 환영합니다.</h1>
	<%}else{ %>
		<div class="content">
		<h1>환영합니다.</h1>
	<%} %>

	<ul>
		<li><a href ="./gugudan">구구단</a></li>
		<li><a href ="./random">랜덤값</a></li>
		<li><a href ="./join">회원가입</a></li>
		<li><a href ="./login">로그인</a></li>
		<li><a href ="./member">멤버</a></li>
		<li><a href ="./board">게시판</a></li>
		<li><a href ="./visit">방명록</a></li>
	</ul>
	</div>

</body>
</html>