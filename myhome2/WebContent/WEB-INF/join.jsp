<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./join" method="post">
	<div>
	<h1>회원가입</h1>
	<label for="id">아이디 : </label>
	<input type="text" name ="id" id="id"><br>
	<label for="password" =>비밀번호 : </label>
	<input type="password" name="password" id="password"><br>
	<label for="email">이메일주소 : </label>
	<input type="text" name="email" id="email">
	<button type="submit">제출</button>
	</div>
	</form>
</body>
</html>