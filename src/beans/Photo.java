package beans;

import java.sql.Date;

import com.mysql.jdbc.Blob;

public class Photo {
	
	private int id;
	private String title;
	private Date date;
	private Blob source;
	private int album_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Blob getSource() {
		return source;
	}
	public void setSource(Blob source) {
		this.source = source;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	
	

}
