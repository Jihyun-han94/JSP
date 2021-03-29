package Board;

import java.sql.Date;

public class BoardVO {
	private int id ;
	private String btye ;
	private String author ;
	private String title ;
	private String context ;
	private Date create_date ;
	private Date update_date ;
	private int view_cnt ;
	private int like_cnt ;
	private int dislike_cnt ;
	
	public BoardVO(int id, String btye, String author, String title,
			String context, Date create_date, Date update_date,
			int view_cnt, int like_cnt, int dislike_cnt) {
		this.id = id;
		this.btye = btye;
		this.author = author;
		this.title = title;
		this.context = context;
		this.create_date = create_date;
		this.update_date = update_date;
		this.view_cnt = view_cnt;
		this.like_cnt = like_cnt;
		this.dislike_cnt = dislike_cnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBtye() {
		return btye;
	}

	public void setBtye(String btye) {
		this.btye = btye;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}

	public int getDislike_cnt() {
		return dislike_cnt;
	}

	public void setDislike_cnt(int dislike_cnt) {
		this.dislike_cnt = dislike_cnt;
	}
	
}
