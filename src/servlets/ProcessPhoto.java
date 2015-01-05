package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PhotoDAO;

/**
 * Servlet implementation class ProcessPhoto
 */
@WebServlet("/images/*")
public class ProcessPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhotoDAO dao = new PhotoDAO();
		String id = request.getPathInfo().substring(1);
		try {
			byte[] content = dao.getImage(id);
		    response.setContentType(getServletContext().getMimeType(id));
		    response.setContentLength(content.length);
		    response.getOutputStream().write(content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
//	@Override
//	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
