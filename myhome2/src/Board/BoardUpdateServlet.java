package Board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardUpdateServlet() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDAO board = new BoardDAO();
		BoardVO data = board.getRecord(id);
		
		request.setAttribute("data", data);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/BoardUpdate.jsp");
		dp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String author = request.getParameter("author");
		String context = request.getParameter("context");
		
		BoardDAO board = new BoardDAO();
		BoardVO data = board.getRecord(id);
		data.setAuthor(author);
		data.setContext(context);
		board.updateData(data);
		
		response.sendRedirect("../board");
	}

}
