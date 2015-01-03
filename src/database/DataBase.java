package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import beans.Album;

public class DataBase {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e) {
			System.out.println("Error Class.forName");
		}
	}

	private String url = null;
	private String user = null;
	private String password = null;
	
	Connection co = null;
	
	public void open() {
		if (url == null) {
			ResourceBundle rb = ResourceBundle.getBundle("base");
			url = rb.getString("url");
			System.out.println("url = "+url);
			user = rb.getString("user");
			System.out.println("user = "+user);
			password = rb.getString("password");
		}
		System.out.println("Openning mysql connection...");
		try {
			co = DriverManager.getConnection(url, user, password);
			System.out.println("Connection opened.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getConnection "+ e.getMessage());
		}
	}
	
	public void close() {
		if (co != null) try {co.close();} catch (Exception e) {}
	}
	
	public void newAlbum(Album album) throws SQLException {
		String sql = "INSERT INTO albums ";
		sql += "(title, date) ";
		sql += "values (?, ?) ";
		
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, album.getTitle());
		ps.setDate(2, album.getDate());
		ps.executeUpdate();
	}
	
	public void updateAlbum(Album album) throws SQLException {
		String sql = "UPDATE albums ";
		sql += "SET title = ?, " ;
		sql += "date = ? ";
		sql += "WHERE id = ?";
		
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, album.getTitle());
		ps.setDate(2, album.getDate());
		ps.setInt(3, album.getId());
		System.out.println(ps.toString());
		ps.executeUpdate();
	}
	
	public void deleteAlbum(int id) throws SQLException {
		String sql = "DELETE FROM albums WHERE id = ?";
		
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
