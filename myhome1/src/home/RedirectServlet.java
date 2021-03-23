package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public RedirectServlet() {
        super();
    }	
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		//redirect 해주기 위한 method (주소 정보를 넣어준다.)
		//로그인 기능 구현할 때 많이 구현 
		//response.sendRedirect("reddone"); //상대경로로 작동 가능
		
		//3초 뒤에 reddone으로 이동해라 
		response.addHeader("Refresh", "3,url = reddone");
		PrintWriter out = response.getWriter();
		out.println("3초 뒤에 reddone 으로 이동합니다.");
		
	}

}
