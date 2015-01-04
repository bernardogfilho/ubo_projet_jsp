<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="database.*" %>
<%@ page import="beans.*" %>

<jsp:useBean id="album" class="beans.Album"></jsp:useBean>
<jsp:useBean id="albumDAO" class="database.AlbumDAO"></jsp:useBean>

<%

%>

<jsp:include page="/shared/header.jsp"></jsp:include>

	<div class="row">
		<div class="small-12 medium-6 small-centered columns">
			<form method="post" action="create.jsp">
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