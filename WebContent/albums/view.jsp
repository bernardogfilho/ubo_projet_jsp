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
<% String id = request.getParameter("id"); %>
<jsp:useBean id="album" class="database.AlbumDAO"></jsp:useBean>

<jsp:include page="/shared/header.jsp"></jsp:include>
<c:set var="album" value="${album.find(param.id)}"/>

	<div class="row">
		<div class="small-12 columns">
			${album.title}
		</div>
	</div>

</body>
</html>