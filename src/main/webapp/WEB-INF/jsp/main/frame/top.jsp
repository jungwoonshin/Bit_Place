<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>

<table id="head1">
	<tr>
	<td>
	  <img src="../img/top/logo.png"/>
	</td>
	<td>
	<select>
		<c:forEach items="${data }" var="e">
		<option>${e.groupname }</option>
		</c:forEach>
	</select>	
	</td>
	</tr>
</table>





