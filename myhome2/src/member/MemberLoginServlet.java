package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 로그인 화면을 요청
//	1-1 로그인과 관련된 쿠키 정보가 있으면 같이 서버에 전송
//2. 서버는 로그인 화면을 클라이언트에 전송
//	2-1.  클라이언트가 보낸 쿠기 정보에 이전에 접속 했던 로그인 기록이 있으면,
//		  해당 로그인 기록을 아이디의 초기값으로 설정해서 전송.
//	2-2. 클라이언트가 보낸 쿠기정보에 이전에 접속 했던 로그인 기록이 없으면,
//		 아이디 입력 화면은 빈값으로 설정해서 전송
//3. 로그인 정보 입력 후 서버에 전송
//4. 서버에서는 전송된 로그인 정보를 이용하여 로그인 처리 후 
//   메인페이지로 리다이렉트 메세지를 클라이언트에 전송
//	4-1. 기억하기 체크박스가 체크되어 있는 경우
//		 ->전송 받은 아이디 값으로 하는 쿠키 생성
//	4-2. 기억하기 체크박스가 체크되어 있지 않은 경우
//		 ->기존에 작성된 쿠기가 있는 경우 시간 만료 시키기(삭제) 
//메인페이지로 리다이렉트 메세지를 클라이언트에 전송 
//5. 서버로 부터 전달받은 리다이렉트 메세지의 url 주소로 요청
//6. 서버는 요청 받은 url에 맞는 화면 전송



@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public MemberLoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//아이디가 저장되어 있는 쿠키가 존재하는 경우 해당 아이디를 추출하여 login.jsp에 전달
		Cookie[] cookies = request.getCookies();
		request.setAttribute("username", "");
		for(Cookie c : cookies) {
			if(c.getName().equals("username")) {
				request.setAttribute("username", c.getValue());
			}
		}
	
		
		
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//기억하기가 체크되어 있으면 아이디값을 저장한 쿠키 생성
		String remember = request.getParameter("remember");
		String username = request.getParameter("username");
		
		System.out.println(remember);
		
		Cookie[] cookies = request.getCookies();
		if(remember != null) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}else {
			for(Cookie c : cookies) {
				c.setMaxAge(-1); //만료시간을 -1하면 아예 쿠키 만료시키는거(삭제) 
				response.addCookie(c);
				break;
			}
		}
		
		
		response.sendRedirect(request.getContextPath());
		                              // localhost:8080/home2
	}

}
