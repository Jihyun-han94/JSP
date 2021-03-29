package Board;

import java.sql.*;
import java.util.ArrayList;

import visit.VisitVO;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstat = null;
	
	public BoardDAO() {
		connect();
	}
	
	
	private void connect() {
		try {
			//JDBC 드라이버 로딩 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 완료!");
			
			//접속 정보 작성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "admin";
			
			//DB 접속 객체 생성 및 접속 시도
			this.conn = DriverManager.getConnection(url,user,password);
			System.out.println("Oracle DB 접속 완료!");
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	//id를 가지고 쿼리 조회 (해당 id에 한한 data만 추출됨)
	public BoardVO getRecord(int id) {
		String sql = "SELECT * FROM board_t WHERE id=?";
		BoardVO record = null;
		
		try {
			this.pstat = this.conn.prepareStatement(sql);
			this.pstat.setInt(1, id); //미리 컴파일
			ResultSet res = this.pstat.executeQuery();
			if(res.next()) {
				record = new BoardVO(
						res.getInt("id"), res.getString("btye"), res.getString("author"),
						res.getString("title"),res.getString("context"),
						res.getDate("create_date"),res.getDate("update_date"),
						res.getInt("view_cnt"),res.getInt("like_cnt"),res.getInt("dislike_cnt")
						);
			}
			
			res.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return record;
	}
	
	//board_t table을 날짜로 조회
	public ArrayList<BoardVO> getRecords(Date date){
		String sql = "";
		sql += "SELECT * FROM board_t";
		sql += "WHERE TO_CHAR(create_date, 'YYYY-MM-DD')=?";
		sql += "ORDER BY id DESC";
		
		ArrayList<BoardVO> records = new ArrayList<BoardVO>();
		
		try {
			this.pstat  = this.conn.prepareStatement(sql);
			this.pstat.setDate(1, date);
			ResultSet res = this.pstat.executeQuery();
			
			while(res.next()) {
				records.add(new BoardVO(res.getInt("id"), res.getString("btye"), res.getString("author"),
						res.getString("title"),res.getString("context"),
						res.getDate("create_date"),res.getDate("update_date"),
						res.getInt("view_cnt"),res.getInt("like_cnt"),res.getInt("dislike_cnt")
						));
			}
			res.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return records;
	}
	public ArrayList<BoardVO> getAll(){
		String sql ="";
		sql += "SELECT * FROM board_t";
		sql += "ORDER BY DESC";
		ArrayList<BoardVO> records = new ArrayList<BoardVO>();
		
		try {
			this.pstat = this.conn.prepareStatement(sql);
			ResultSet res = this.pstat.executeQuery();
			
			while(res.next()) {
				records.add(new BoardVO(
						res.getInt("id"), res.getString("btye"), res.getString("author"),
						res.getString("title"),res.getString("context"),
						res.getDate("create_date"),res.getDate("update_date"),
						res.getInt("view_cnt"),res.getInt("like_cnt"),res.getInt("dislike_cnt")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	
	public int saveData(BoardVO data) {
		int result = 0;
		String sql ="";
		sql += "INSERT INTO board_t(id, btye, author, title, context, create_date, update_date,view_cnt, like_cnt)";
		sql += "VALUES(board_seq.NEXTVAL,?,?,?,SYSDATE,SYSDATE,0,0,0)";
		
		try {
			this.pstat = this.conn.prepareStatement(sql);
			this.pstat.setString(1, data.getAuthor());
			this.pstat.setString(2, data.getTitle());
			this.pstat.setString(3, data.getContext());
			
			result = this.pstat.executeUpdate(); // 저장 처리가 완료되면 1 반환
			System.out.println(result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	public int deleteData(int id) {
		int result = 0;
		String sql = "";
		sql += "DELETE FROM board_t";
		sql += "WHERE ID =?";
		
		try {
			this.pstat = this.conn.prepareStatement(sql);
			this.pstat.setInt(1, id);
			
			result = this.pstat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void close() {
		try {
			this.pstat.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
