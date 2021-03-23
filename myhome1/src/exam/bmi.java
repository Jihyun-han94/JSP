package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bmi
 */
@WebServlet("/bmi/res")
public class bmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bmi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		
		int weight_int = Integer.parseInt(weight);
		int height_int = Integer.parseInt(height);
		
		double height2 = (double)height_int /100;
		
		request.setAttribute("weight_int", weight_int);
		request.setAttribute("height_int", height_int);
		request.setAttribute("height2", height2);
		
		//RequestDispatcher dp = request.getRequestDispatcher("res/view");
		RequestDispatcher dp = request.getRequestDispatcher("res.jsp");
		dp.forward(request, response);
		
	}
}


