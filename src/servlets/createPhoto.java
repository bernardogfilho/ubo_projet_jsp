package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.PhotoDAO;

import beans.Photo;

@WebServlet("/createPhoto")
@MultipartConfig(maxFileSize = 16177215)
public class createPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public createPhoto() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String albumId = request.getParameter("album_id");
		
		InputStream inputStream = null;
		
		Part filePart = request.getPart("source");
		if (filePart != null) {
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			inputStream = filePart.getInputStream();
		}
		
		Photo photo = new Photo();
		PhotoDAO dao = new PhotoDAO();

		photo.setTitle(title);
		try {
			photo.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		photo.setSource(inputStream);
		photo.setAlbumId(Integer.parseInt(albumId));
		try {
			dao.create(photo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/ihm_jsp/albums").forward(request, response);
	}

}
