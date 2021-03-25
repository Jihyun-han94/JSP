package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.MemberDAO;

@WebServlet("/member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Member() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO member = new MemberDAO();
		MemberVO m = member.getRecord("admin");
		member.close();
		
		System.out.println(m.getUserid());
		System.out.println(m.getPassword());
		System.out.println(m.getEmail());
		System.out.println(m.getJoindate());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


}
}