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
		Album newAlbum = new Album(title, date);
		System.out.println(newAlbum.getTitle());
		DataBase db = new DataBase();
		db.open();
		db.newAlbum(newAlbum);
		db.close();
	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://cdn.foundation5.zurb.com/foundation.css"></link>
</head>
<body>

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