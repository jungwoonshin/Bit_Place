<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<table class="table table-striped">
<tr>
<td>name</td>
<td>kor</td>
<td>eng</td>
<td>math</td>
</tr>
<c:forEach var="e" items="${data }">
<tr>
<td>${e.name }</td>
<td>${e.kor }</td>
<td>${e.eng }</td>
<td>${e.math }</td>
</tr>
</c:forEach>
</table>
