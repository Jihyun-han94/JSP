package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeHomeSweetHome") //주소 바꿀 수 있음
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//response에 메세지를 담아서 사용자한테 보냄 
		
		// * 응답 인코딩 설정 * 중요!!
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	
		PrintWriter out = response.getWriter();
		String html = "";
		html +="<!DOCTYPE html>";
		html +="<html lang=\"en\">";
		html +="<head>";
		html +="    <meta charset=\"UTF-8\">";
		html +="</head>";
		html +="<body>";
		html +="    <table>";
		html +="        <thead>";
		html +="            <tr>";
		html +="                <th>번호</th>";
		html +="                <th>제목</th>";
		html +="                <th>일자</th>";
		html +="            </tr>";
		html +="        </thead>";
		for(int i = 1; i<=10 ; i++){
		html +="    <tr>";
		html +="<td>" + i + "</td>";
		html +="<td>안녕하세요</td>";
		html +="<td>3/17</td>";
		html +="</tr>";
		}
		
		html +="    </table>";
		html +="</body>";
		html +="</html>";

		
		out.println(html);
	}

}
