package beans;

import java.sql.Date;

public class Photo {
	
	private int id;
	private String title;
	private Date date;
	private java.sql.Blob source;
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
	public java.sql.Blob getSource() {
		return source;
	}
	public void setSource(java.sql.Blob blob) {
		this.source = blob;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	
	

}
