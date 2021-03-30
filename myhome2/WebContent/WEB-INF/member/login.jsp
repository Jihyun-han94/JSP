<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./login" method="post">
	<div>
		<label for="id_username" name="username">아이디</label>
		<input type="text" name="username" value=<%=request.getAttribute("username") %> required>
	</div>
		<div>
		<label for="id_password">패스워드</label>
		<input type="text" id ="id_password" name="username" required>
	</div>
		<div>
		<%
			if(((String)request.getAttribute("username")).equals("")) {
		%>			
		<input type="checkbox" id="id_remember" name="remember" >
		<%
		}else{
		%>
			<input type="checkbox" id="id_remember" name="remember" checked>
		<%
		}
		%>	

		<label for="id_remember" name="remember">기억하기</label>
		</div>
	<div>
		<button type="submit">버튼</button>
	</div>
	</form>
</body>
</html>