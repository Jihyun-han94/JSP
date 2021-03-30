package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/login.jsp");
		dp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		String password = request.getParameter("password");
		System.out.println(password);
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		String id_ori = "gkswlgus923";
		String password_ori = "tnwjd923"; 
		
		if(id.equals(id_ori) && password.equals(password_ori)) {
			System.out.println("correct");
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/login_success.jsp");
			dp.forward(request, response);
		}else {
			System.out.println("fail");
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/login_fail.jsp");
			dp.forward(request, response);
		}
	}

}
