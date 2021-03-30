<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList,Board.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판</h1>
	<form action="./board" method = "post">
		<input type = "text" name ="author" placeholder="작성자" required>
		<input type = "text" name ="btye" placeholder="바이트" required>
		<input type = "text" name ="title" placeholder="제목" required>
		<input type = "text" name ="context" placeholder="내용" required>
		<button type = "submit">작성</button>
	</form>
	<table border = "1">
		<tr>
			<th>번호</th>
			<th>구분</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th>수정일</th>
			<th>조회수</th>
			<th>좋아요수</th>
			<th>싫어요수</th>
			<th></th>
		</tr>
		<% ArrayList<BoardVO> datas = (ArrayList<BoardVO>)request.getAttribute("datas");
           for(BoardVO data: datas) { %>
		<tr>
			<td><%=data.getId() %></td>
			<td><a href="./board/update?id=<%=data.getId()%>"><%=data.getContext() %></a></td>
			<td><%= data.getAuthor() %></td>
			<td><%= data.getTitle() %></td>
			<td><%= data.getCreate_date() %></td>
			<td><%= data.getTitle() %></td>
			<td><form action="./board/delete" method="post">
                   <input type="hidden" name="id" value="<%=data.getId() %>" readonly>
                   <button type="submit">삭제</button>
               </form></td>
		</tr>
		<%} %>	
	</table>
</body>
</html>