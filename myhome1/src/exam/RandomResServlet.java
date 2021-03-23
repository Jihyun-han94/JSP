package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomResServlet
 */
@WebServlet("/exam/random/res")
public class RandomResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomResServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String html = "";
		
		html += "<!DOCTYPE html>";
		html += "<html lang=\"en\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		
		response.setContentType("UTF-8");
		String mn = request.getParameter("mn");
		String mx = request.getParameter("mx");
		String rn = request.getParameter("rn");
		
		int rn_int = Integer.parseInt(rn);
	
		
		
		String color = "";
		if( 1<= rn_int && 20>=rn_int) {
			color = "#F85615";
		}else if(21<=rn_int && 40>= rn_int) {
			color = "#F8165C";
		}else if (41<=rn_int && 60>= rn_int) {
			color = "#F8156C";
		}else if (61<=rn_int && 80>= rn_int) {
			color = "#F8E114";
		}else if (81<=rn_int && 100>= rn_int) {
			color = "#F8E115";
		}
		html += "<h2 style=\"color:"+color+"\">"+rn+"</h2>";
		html += "</body>";
		html += "</html>";
		
		out.print(html);
	}

}
