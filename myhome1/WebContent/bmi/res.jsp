<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
<% int weight_int = (int)request.getAttribute("weight_int");%>
<% int height_int = (int)request.getAttribute("height_int");%>
<% double height2 = (double)request.getAttribute("height2"); %>

<label>bmi 결과를 출력하겠습니다.</label><br>

<% double BMI = weight_int / height2;%> 
        
<label>몸무게는"+weight_int+" 입니다.</label><br> 
<label>키는"+height_int+" 입니다.</label><br> 
<label>키는"+height2+" 입니다.</label><br>  
        
<label> bmi 수치는"+BMI+" 입니다.</label><br>        
        
         <% if(BMI< 20){ %>
        	 <label>저체중입니다.</label>    	
        <% }else if(BMI>=20 && BMI<=24){%>
        	<label>정상체중입니다.</label>
        <%}else if(BMI>=25 && BMI<=29){%>
        	 <label>과체중입니다.</label>
        	
        <%}else if(BMI>=30 && BMI<=34){%>
        	 <label>비만입니다.</label>
        
        <% }else if(BMI >=35){%>
        	 <label>고도비만입니다.</label>
        
        <%}else{%>
        	 <label>잘못 입력하셨습니다.</label>
        <%}%> 
        
</body>
</html>