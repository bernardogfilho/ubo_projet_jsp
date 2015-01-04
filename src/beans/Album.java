package beans;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class Album {
	
	private int id;
	private String title;
	private Date date;
	private ArrayList<Photo> photos;
	
	public Album(String title, String date) throws ParseException {
		this.title = title;
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		java.sql.Date sqlDate = new java.sql.Date(df.parse(date).getTime());
		this.date = sqlDate;
	}
	
	public Album() {
		this.photos = new ArrayList<Photo>();  
	}

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

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}
	
	public void addPhoto(Photo photo) {
		this.photos.add(photo);
	}

}
