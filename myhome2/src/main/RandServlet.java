package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/random")
public class RandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/rand.jsp");
			dp.forward(request, response);
			
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int min = Integer.parseInt(request.getParameter("min"));
		int max = Integer.parseInt(request.getParameter("max"));
		 System.out.println(min);
		 System.out.println(max);
		 
//		 if(max < min) {
//			 RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/range.jsp");
//			 request.setAttribute("message", "최소/최대 값 범위 설정이 잘못 되었습니다.");
//			 dp.forward(request, response);
//		 }
//		 
		// if (max < min) {
			// 	RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/range.jsp");
			// 	request.setAttribute("message", "최소/최대 값 범위 설정이 잘못 되었습니다.");
			// 	dp.forward(request, response);
			// }
		 
		 
		 
		int [] random_arr = new int[6];
		
		for(int i =0 ; i<6 ; i++) {
			  random_arr[i] = new Random().nextInt(max - min +1) + min ;	
			 
		}
		
		request.setAttribute("random_arr", random_arr);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/randres.jsp");
		dp.forward(request, response);
	}
}
