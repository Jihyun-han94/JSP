package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/exam/gugudan")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		
		String gugu = request.getParameter("gugu");
		
		int gugu_int;
		gugu_int= Integer.parseInt(gugu); 
		
		PrintWriter out = response.getWriter();
		String html = "";
		
		html +="<!DOCTYPE html>";
		html +="<html lang=\"en\">";
		html +="<head>";
		html +="    <meta charset=\"UTF-8\">";
		html +="    <title>Document</title>";
		html +="</head>";
		html +="<body>";
		html += gugu+"단을 출력하겠습니다.";
		
						
		                for(int i = gugu_int; i <= gugu_int ; i++){
		                	html +="    <table border=\"1\">";
		                for(int y =1; y < 10 ; y++){
		html +="                <tr>";                	
		html +="                <td>"+ i +"</td>";
		html +="                <td>*</td>";
		html +="                <td>"+ y +"</td>";
		html +="                <td>=</td>";
		html +="                <td>"+ i*y + "</td>";
		html +="                </tr>"; 
		            }
		                html +="    </table>";
				}
		
		html +="</body>";
		html +="</html>";
		out.println(html);
			}
		}
	
