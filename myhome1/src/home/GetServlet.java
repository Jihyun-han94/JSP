package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/home/getdata")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 메서드 동작");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자가 요청한 prameter를 가져옴
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String z [] = request.getParameterValues("z"); //배열로 저장함
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		PrintWriter out = response.getWriter();
		String html = "";
		
		html += "<br>doGet() 메서드 동작";
		html += "<br>파라미터 x 값 추출" + x;
		out.print(html);
		
		System.out.println("doGet() 메서드 동작");
		System.out.println("파라메터 값을 추출 하였습니다." + x);
		System.out.println("파라메터 값을 추출 하였습니다." + y);
		System.out.println("파라메터 값을 추출 하였습니다." + z.length); // 배열 길이 추출
		System.out.println("파라메터 값을 추출 하였습니다." + z[0]); // 0번 index의 value 추출
		System.out.println("파라메터 값을 추출 하였습니다." + z[1]); // 1번 index의 value 추출
		
	}

}
