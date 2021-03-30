<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Board.BoardVO" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <% BoardVO data = (BoardVO)request.getAttribute("data"); %>
    <form action="./update" method="post">
    	<div>
    	    <input type="hidden" name="id" value="<%= data.getId() %>" readonly>
    	</div>
    	<div>
    	    <input type="text" name="author" value="<%= data.getAuthor() %>" readonly>
    	</div>
        <div>
    	    <textarea name="context"><%= data.getContext() %></textarea>
    	</div>
    	<div>
    	    <button type="submit">수정</button>
    	</div>
	</form>
</body>
</html>