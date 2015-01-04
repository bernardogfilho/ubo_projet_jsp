<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="database.*" %>
<%@ page import="beans.*" %>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="albumDAO" class="database.AlbumDAO"></jsp:useBean>

<%
	
%>

<jsp:include page="/shared/header.jsp"></jsp:include>

	<div class="row">
		<div class="small-12 columns">
			<h4>Bienvenue à votre gestionnaire d'albums.</h4>
			<ul>
				<li>Voilá</li>
				<c:forEach items="${albumDAO.findAll()}" var="album">
					<li><c:out value="${album.title}"></c:out></li>
				</c:forEach>
			</ul>
		</div>
		<h1></h1>
	</div>

</body>
</html>