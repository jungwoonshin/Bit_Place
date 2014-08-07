<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="e" items="${ajax_data }">
	<div>
	<span class="content_commitinfo_img">
	<img src="../img/content/fileicon.png" id="${e.sha }"> 
	</span>
	<span> 
	${e.path }
	</span> 
	</div>
</c:forEach>

