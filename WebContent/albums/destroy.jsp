<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<jsp:useBean id="album" class="beans.Album"></jsp:useBean>
<jsp:useBean id="albumDAO" class="database.AlbumDAO"></jsp:useBean>

<%

String id = request.getParameter("id");

if (id != null) {
	albumDAO.destroy(Integer.parseInt(id));
}
%>

<c:redirect url="/albums"/>
