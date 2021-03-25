package board;

import java.sql.Date;

public class boardVO {
	
	private Integer board_num = null;
	private String board_type = null;
	private String title = null;
	private String context = null;
	private String author = null;
	private Date create_date = null;
	private Date update_date = null;
	private Integer view_count = null;
	
	public boardVO(Integer board_num, String board_type, String title,
			String context, String author, Date create_date, Date update_date,
			Integer view_count) {
		this.board_num = board_num;
		this.board_type = board_type;
		this.title = title;
		this.context = context;
		this.author = author;
		this.create_date = create_date;
		this.update_date = update_date;
		this.view_count = view_count;
	}

	public Integer getBoard_num() {
		return board_num;
	}

	public void setBoard_num(Integer board_num) {
		this.board_num = board_num;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getView_count() {
		return view_count;
	}

	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
	
	

}
