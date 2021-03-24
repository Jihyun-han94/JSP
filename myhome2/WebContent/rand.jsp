<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./random/res" method="post">
	<h1>랜덤값 범위 설정</h1>
	<input type="text" name="min" placeholder="최소값" required>
	<input type="text" name="max" placeholder="최대값" required>
	<button type="submit" >설정</button>
	</form>
</body>
</html>