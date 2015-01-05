package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import beans.Album;
import beans.Photo;

public class AlbumDAO extends DataBase {
	
	public AlbumDAO(){
		
	}
	
	public void create(Album album) throws SQLException {
		String sql = "INSERT INTO albums ";
		sql += "(title, date) ";
		sql += "values (?, ?) ";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, album.getTitle());
		ps.setDate(2, album.getDate());
		ps.executeUpdate();
		close();
	}
	
	public void update(Album album) throws SQLException {
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
	
	public void destroy(int id) throws SQLException {
		String sql = "DELETE FROM photos WHERE album_id=?";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		sql = "DELETE FROM albums WHERE id = ?";
		ps = co.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		close();
	}
	
	public Album find(String id) throws SQLException{
		String sql = "SELECT * FROM albums WHERE id=?";
		Album album = new Album();
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		album.setId(rs.getInt("id"));
		album.setTitle(rs.getString("title"));
		album.setDate(rs.getDate("date"));
		sql = "SELECT * FROM photos WHERE album_id=?";
		ps = co.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		while(rs.next()) {
			Photo photo = new Photo();
			photo.setId(rs.getInt("id"));
			photo.setAlbumId(Integer.parseInt(id));
			photo.setDate(rs.getDate("date"));
			photo.setTitle(rs.getString("title"));
			photo.setSource(rs.getBinaryStream("source"));
			album.addPhoto(photo);
		}
		return album;
	}
	
	public ArrayList<Album> findAll() throws SQLException, ParseException {
		open();
		String sql = "SELECT * FROM albums";
		ArrayList<Album> albums = new ArrayList<Album>();
		PreparedStatement ps = co.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Album album = new Album();
			album.setId(rs.getInt("id"));
			album.setTitle(rs.getString("title"));
			album.setDate(rs.getDate("date"));
			albums.add(album);
		}
		close();
		return albums;
	}

}
