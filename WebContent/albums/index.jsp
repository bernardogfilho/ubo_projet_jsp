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
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="album" class="database.AlbumDAO"></jsp:useBean>

<jsp:include page="/shared/header.jsp"></jsp:include>

	<div class="row">
		<ul class="small-block-grid-1 medium-block-grid-4">
			<c:forEach items="${album.findAll()}" var="album">
				<li class="text-center">
					<strong>${ album.title }</strong>
					<br/>
					<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${album.date}" />
					<br/>
					<a href="#">Editer</a> | <a href="/ihm_jsp/albums/destroy.jsp?id=${album.id}">Surpimer</a>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>