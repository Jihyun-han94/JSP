package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public boardServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boardDAO board = new boardDAO();
		boardVO b = board.getRecord("한지현");
		board.close();
		
		System.out.println(b.getAuthor());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
