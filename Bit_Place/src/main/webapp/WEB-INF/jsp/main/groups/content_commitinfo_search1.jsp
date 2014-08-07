<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%int content_commitinfo_btn_num = 0; %>

<c:forEach items="${ajax_data }" var ="e" varStatus="no">
<% content_commitinfo_btn_num++; %>

<div class="content_commitinfo_line">
<span class="content_commitinfo_img">
<c:choose>
	<c:when test="${e.type=='tree'}">
	<img src="../img/content/foldericon.png" class="${e.sha}" id='content_commitinfo_folderbtn_${no.index}'>
	</c:when>
	<c:when test="${e.type=='blob'}">
	<img src="../img/content/fileicon.png" class="${e.sha }" id="content_commitinfo_searchbtn_${no.index }">
	</c:when>
</c:choose>
</span>	
<span class="content_commitinfo_files_${no.index }" id="${e.sha}">${e.path }</span>
</div>
<c:if test="${e.type=='tree' }">
	<div id="sub_content_commitinfo_folderbtn_${no.index}" class="testsubs"></div>
</c:if>
</c:forEach>

<input type="hidden" value="<%=content_commitinfo_btn_num %>" id="content_commitinfo_btn_num2">

