<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="database.*" %>
<%@ page import="beans.*" %>
<jsp:useBean id="album" class="database.AlbumDAO"></jsp:useBean>

<jsp:include page="/shared/header.jsp"></jsp:include>
<c:set var="album" value="${album.find(param.id)}"/>

	<div class="row">
		<div class="small-12 columns">
			<br/>
			<h3>${album.title}</h3>
			<i>Publié en <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${album.date}" /></i>
			<br/><br/>	
			<a class="button tiny" href="photos/new.jsp?album_id=${album.id}">Ajouter un photo</a>
		</div>
	</div>
	<div class="row">
		<div class="small-12 columns">
			<ul class="small-block-grid-1 medium-block-grid-4">
				<c:forEach items="${album.photos}" var="photo">
					<li>
						<img alt="" src="/ihm_jsp/images/${photo.id}">
						${photo.title}
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>