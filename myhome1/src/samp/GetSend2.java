package samp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetSend2
 */
@WebServlet("/home/getsend2")
public class GetSend2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSend2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8" );
	
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		String html = "";
		html += "Client :" + pass;
		html += "<br>";
		html += "Server : 메세지를 잘 받았습니다.";  
		out.print(html);
		
		
	}

}
