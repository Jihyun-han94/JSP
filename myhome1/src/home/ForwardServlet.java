package home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/forward1")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ForwardServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		//사용자 요청에 대한 처리...
		RequestDispatcher dispatcher = request.getRequestDispatcher("fwdone1");
		dispatcher.forward(request, response); //가지고 있는 요청과 응답에 대한 데이터를 담아서 보내줌 
		//redirect와 refresh 방식과 달리 url 주소가 바뀌지 않는다는 장점을 가지고 있다.
		//redirect와 refresh 방식보다 더 적은 네트워크 트래픽을 가지고 있음.
		
	}

}
