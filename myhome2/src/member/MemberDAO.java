package member;

import java.sql.*;

// DAO(Data Access Object)
//     데이터 베이스 접속과 관련된 메서드를 정의
public class MemberDAO {
	private Connection conn = null;
	private Statement stat = null;
	
	public MemberDAO() {
		this.connect();
	}
	
	public MemberVO getRecord(String userid) {
		// SQL 질의문 작성
		String sql = "SELECT * FROM member_t WHERE userid = 'admin'";
		MemberVO m = null;
		try {
			// SQL 질의문 실행
			ResultSet res = this.stat.executeQuery(sql);
			
			if(res.next()) {//읽을 내용이 있으면 true 반환
				m = new MemberVO(
						res.getString("userid"), res.getString("password"),
						res.getString("email"),	res.getDate("joindate")
						);				
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m;
	}
	
	private void connect() {
		try {
			// JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 완료!");
			
			// 접속 정보 작성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "admin";
			
			// DB 접속 객체 생성 및 접속 시도
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle DB 접속 완료!");
			
			//데이터베이스로 SQL문을 보내기 위한 SQLServerResultSet 객체를 만든다.
			// SQL 구문 작업용 객체 생성
			this.stat = this.conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		// 모든 JDBC 관련 생성 객체 정보 close()
		try {
			this.stat.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}