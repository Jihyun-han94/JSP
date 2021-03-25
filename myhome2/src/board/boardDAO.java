package board;

import java.sql.*;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.spi.orbutil.fsm.State;

public class boardDAO {

	private Connection conn = null;
	private Statement stat = null;
	
	public boardDAO() {
		this.connect();
	}
	
	public boardVO getRecord(String author) {
		
		String sql = "SELECT * FROM board_t WHERE author ='한지현'";
		
		boardVO b = null;
		
		try {
			ResultSet res;
			res = this.stat.executeQuery(sql);
			res.next();
			b = new boardVO(
				res.getInt("board_num"),res.getString("board_type"),
				res.getString("title"),res.getString("context"),
				res.getString("author"), res.getDate("create_date"),
				res.getDate("update_date"),res.getInt("view_count"));
				res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
					
		return b;
	}
	
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 완료");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "admin";
			
			this.conn = DriverManager.getConnection(url, user, password);
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
