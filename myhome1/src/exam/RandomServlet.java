package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomServlet
 */
@WebServlet("/exam/random")
public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		int start_int = Integer.parseInt(start);
		int end_int = Integer.parseInt(end);
		
		PrintWriter out = response.getWriter();
		String html = "";
		
		html += "<!DOCTYPE html>";
		html += "<html lang=\"en\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		
	
		int num = (int)(Math.random()* end_int)+start_int;
		
		String color = "";
		if( 1<= num && 20>=num) {
			color = "#F85615";
		}else if(21<=num && 40>= num) {
			color = "#F8165C";
		}else if (41<=num && 60>= num) {
			color = "#F8156C";
		}else if (61<=num && 80>= num) {
			color = "#F8E114";
		}else if (81<=num && 100>= num) {
			color = "#F8E115";
		}
		html += "<h2 style=\"color:"+color+"\">"+num+"</h2>";
		html += "</body>";
		html += "</html>";
		
		out.print(html);
	}

}
