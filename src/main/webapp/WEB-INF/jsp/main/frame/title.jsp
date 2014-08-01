<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>

<table id="head_table">
<tr>
<c:forEach items="${data }" var="e">
<td>
	<div id="title_btn">
	${e.title }
	</div>
</td>
</c:forEach>
</tr>
</table>



