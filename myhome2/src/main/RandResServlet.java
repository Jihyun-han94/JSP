package main;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandResServlet
 */
@WebServlet("/random/res")
public class RandResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandResServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int min = Integer.parseInt(request.getParameter("min"));
		int max = Integer.parseInt(request.getParameter("max"));
		 System.out.println(min);
		 System.out.println(max);
		int [] random_arr = new int[6];
		
		for(int i =0 ; i<6 ; i++) {
			  random_arr[i] = new Random().nextInt(max - min +1) + min ;	
			 
		}
		
		request.setAttribute("random_arr", random_arr);
		RequestDispatcher dp = request.getRequestDispatcher("../randres.jsp");
		dp.forward(request, response);
	}
}
