<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="database.*" %>
<%@ page import="beans.*" %>

<jsp:useBean id="photo" class="beans.Photo"></jsp:useBean>
<jsp:useBean id="photoDAO" class="database.PhotoDAO"></jsp:useBean>

<%

%>

<jsp:include page="/shared/header.jsp"></jsp:include>

	<div class="row">
		<div class="small-12 columns">
			<br/>
			<h3>Ajouter un nouvel photo.</h3>
			<i>Vous pouvez ajouter un nouvel photo...</i>
			<br/><br/>
		</div>
	</div>

	<div class="row">
		<div class="small-12 medium-6 columns">
			<form method="post" action="/ihm_jsp/createPhoto" enctype="multipart/form-data">
				<label>Titre
					<input type="text" name="title">
				</label>
				<label>Date
					<input type="text" name="date">
				</label>	
				<label>
					<input type="file" name="source">
				</label>					
				<input type="hidden" name="album_id" value="${param.album_id}">
				<input class="button expand" name="submit" type="submit" value="Submit">
			</form>
		</div>
	</div>

</body>
</html>