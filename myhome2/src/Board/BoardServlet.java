package Board;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visit.VisitDAO;
import visit.VisitVO;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO board = new BoardDAO();
		ArrayList<BoardVO> datas = board.getAll();
		board.close();
		
		request.setAttribute("datas", datas);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/Board.jsp");
		dp.forward(request, response);
		System.out.println("forward  완료");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1. 클라이언트가 전달한 파라메터 추출
		String author = request.getParameter("author");
		String context = request.getParameter("context");
		String btye = request.getParameter("btye");
		String title = request.getParameter("title");
		
		System.out.println(author);
		System.out.println(context);
		System.out.println(btye);
		System.out.println(title);
		
		
		
		
		// 2. 추출한 파라메터를 VisitVO 를 생성하여 저장
		BoardVO data = new BoardVO(author, btye,title,context);
		
		// 3. VisitDAO 를 생성 후 2번에서 만든 VisitVO 를 전달 후 저장
		BoardDAO board = new BoardDAO();
		board.saveData(data);
		System.out.println("saveData 넘겨줌");
		board.close();
		
		// 4. 저장 완료 후 localhost:8080/home2/visit 를 다시 요청하도록 클라이언트에
		//    리다이렉트 메시지 전달
		response.sendRedirect("./board");
	}
	
}


