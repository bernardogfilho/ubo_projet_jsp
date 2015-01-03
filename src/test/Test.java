package test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

import beans.Album;
import database.DataBase;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ParseException, SQLException {
		
		DataBase db = new DataBase();
		db.open();
		
		Album a = new Album();
		
		a.setTitle("My vocations 2014");
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		java.sql.Date sqlDate = new java.sql.Date(df.parse("03/01/2015").getTime());
		a.setDate(sqlDate);
		
		db.newAlbum(a);

	}

}
