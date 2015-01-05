package beans;

import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

public class Photo {
	
	private int id;
	private String title;
	private Date date;
	private InputStream source;
	private int albumId;
	
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
	
	public void setDate(String date) throws ParseException{
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		java.sql.Date sqlDate = new java.sql.Date(df.parse(date).getTime());
		this.date = sqlDate;
	}
	
	public InputStream getSource() {
		return source;
	}
	public void setSource(InputStream source) {
		this.source = source;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int album_id) {
		this.albumId = album_id;
	}
	
	

}
