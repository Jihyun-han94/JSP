package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LottoServlet
 */
@WebServlet("/exam/lotto")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LottoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String set = request.getParameter("set");
		int set_int = Integer.parseInt(set);
		
		PrintWriter out = response.getWriter();
		String html = "";
		
		html += "<!DOCTYPE html>";
		html += "<html lang=\"en\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>1~45 범위의 로또 번호 생성</title>";
		html += "</head>";
		html += "<body>";
		//중복 생성되면 안됨 
		
		ArrayList<Integer> lotto = new ArrayList();
		
		
			while(lotto.size()<set_int) {
				int num = (new Random()).nextInt(45)+1;
				if(!lotto.contains(num)) {
					lotto.add(num);				
				}
			}
		
		
		
		for(Object x : lotto) {
			html += "<span>"+x+","+"</span>";
		}
		html += "<h2>"+lotto+"</h2>";
		html += "</body>";
		html += "</html>";
		
		out.print(html);
	}
	
	}


