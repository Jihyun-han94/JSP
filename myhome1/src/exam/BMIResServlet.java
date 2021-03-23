package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bmi/res/view")
public class BMIResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BMIResServlet() {
        super();
   
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		int weight_int = (int)request.getAttribute("weight_int");
		int height_int = (int)request.getAttribute("height_int");
		double height2 = (double)request.getAttribute("height2");
				
		PrintWriter out = response.getWriter();
		String html = "";
		
		html += "<!DOCTYPE html>";
		html += "<html lang=\"ko\">";
		html += "	<head>";
		html += "	<meta charset=\"UTF-8\">";
		html += "	<title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "	<label>bmi 결과를 출력하겠습니다.</label><br>";

        double BMI = weight_int / height2; 
        
        html += "	<label>몸무게는"+weight_int+" 입니다.</label><br>"; 
        html += "	<label>키는"+height_int+" 입니다.</label><br>"; 
        html += "	<label>키는"+height2+" 입니다.</label><br>";  
        
        html += "	<label>bmi 수치는"+BMI+" 입니다.</label><br>";        
        if(BMI< 20){
        	html += "<label>저체중입니다.</label>";
        	
        
        }else if(BMI>=20 && BMI<=24){
        	html +="<label>정상체중입니다.</label>";
        	
                       
        }else if(BMI>=25 && BMI<=29){
        	html += "<label>과체중입니다.</label>";
        	
        }else if(BMI>=30 && BMI<=34){
        	html += "<label>비만입니다.</label>";
        
        }else if(BMI >=35){
        	html += "<label>고도비만입니다.</label>";
        
        }else{
        	html += "<label>잘못 입력하셨습니다.</label>";
        }
        
		html += "</body>";
		html += "</html>";
		
		out.println(html);
		
	}
	

}
