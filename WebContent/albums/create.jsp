<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<jsp:useBean id="album" class="beans.Album"></jsp:useBean>
<jsp:useBean id="albumDAO" class="database.AlbumDAO"></jsp:useBean>

<%

String title = request.getParameter("title");
String date = request.getParameter("date");

if (title != null && date != null) {
	album.setTitle(title);
	album.setDate(date);
	albumDAO.create(album);
}
%>

<c:redirect url="/albums"/>
