<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="database.*" %>
<%@ page import="beans.*" %>

<jsp:useBean id="album" class="beans.Album"></jsp:useBean>

<%

	String title = request.getParameter("title");
	String date = request.getParameter("date");
	
	if (title != null && date != null) {
		album.setTitle(title);
		album.setStringDate(date);
		DataBase db = new DataBase();
		db.open();
		db.newAlbum(album);
		db.close();
	}

%>

<jsp:include page="/shared/header.jsp"></jsp:include>

	<div class="row">
		<div class="small-12 medium-6 small-centered columns">
			<form method="post" action="new_album.jsp">
				<label>Titre
					<input type="text" name="title">
				</label>
				<label>Date
					<input type="text" name="date">
				</label>						
				<input class="button expand" name="submit" type="submit" value="Submit">
			</form>
		</div>
	</div>

</body>
</html>