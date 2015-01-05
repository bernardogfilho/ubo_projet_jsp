package database;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.xlightweb.MultipartFormDataRequest;

import beans.Photo;

public class PhotoDAO extends DataBase{

	public PhotoDAO(){

	}

	public void create(Photo photo) throws SQLException{
		String sql = "INSERT INTO photos ";
		sql += "(title, date, source, album_id) ";
		sql += "VALUES (?, ?, ?, ?)";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, photo.getTitle());
		ps.setDate(2, photo.getDate());
		ps.setBlob(3, photo.getSource());
		ps.setInt(4, photo.getAlbumId());
		ps.executeUpdate();
		ps.close();
	}
	
	public byte[] getImage(String id) throws SQLException {
		String sql = "SELECT source FROM photos WHERE id=?";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getBytes("source");
	}

}
