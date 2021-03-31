<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link type="text/css" rel="stylesheet"
    href="<%=request.getContextPath() %>/static/bootstrap-4.6.0/css/bootstrap.min.css">
<script type="text/javascript"
    src="<%=request.getContextPath() %>/static/jquery/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
    src="<%=request.getContextPath() %>/static/bootstrap-4.6.0/js/bootstrap.min.js"></script>
<%@ include file="/WEB-INF/module/top_nav.jsp" %>
</head>
<body>
    <%
        String username = "";
        if(request.getAttribute("username") != null) {
        	username = (String)request.getAttribute("username");
        }
    %>
    <form action="./login" method="post">
        <div>
            <label for="id_username">아이디</label>
            <input type="text" id="id_username" name="username"
                value="<%=username %>" required>
        </div>
        <div>
            <label for="id_password">패스워드</label>
            <input type="password" id="id_password" name="password" required>
        </div>
        <div>
            <%
                if(username.equals("")) {
            %>
                    <input type="checkbox" id="id_remember" name="remember">
            <%
                } else {
            %>
                    <input type="checkbox" id="id_remember" name="remember" checked>
            <%
                }
            %>
            <label for="id_remember">기억하기</label>
        </div>
        <div>
            <button type="submit">로그인</button>
        </div>
    </form>
</body>
</html>