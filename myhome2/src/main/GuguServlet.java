package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/gugudan")
public class GuguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuguServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/gugu.jsp");
		dp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		if(request.getParameter("dan_num") ==null || request.getParameter("dan_num").equals("")) {
//			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/noparam.jsp");
//		}
		
		
		int dan_num = Integer.parseInt(request.getParameter("dan_num"));
		
		ArrayList<String> gugu_res = new ArrayList();
		
		for(int i = 1; i <=9 ; i++) {
			gugu_res.add(dan_num + "x" + i + "=" + (i*dan_num));
		}
		
		request.setAttribute("gugu_res", gugu_res);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/gugures.jsp");
		dp.forward(request, response);
	}

}
