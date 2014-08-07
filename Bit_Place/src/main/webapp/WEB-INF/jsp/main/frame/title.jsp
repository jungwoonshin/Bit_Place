<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<script type="text/javascript" src="../js/sub_auto.js"></script>
<script type="text/javascript" src="../js/sub_passive.js"></script>

<style>
#totalTitleNum{
display : none;
}
</style>

<% int totalTitleNum=0; %>
<table id="head_table">
<tr>
<td width="10px">
</td>
<c:forEach items="${data }" var="e" varStatus="no">
<% totalTitleNum++; %>
<td>
	<div id="title_wrapper">
	<div id="title_btn" class="title_btn_${no.index }" value="${e.titleno }">
		${e.title }
	</div>
	</div>
</td>
</c:forEach>
<td>
	<div id="title_wrapper">
	<div id="title_addbtn">
	</div>
	</div>
</td>
</tr>
</table>
<input type="text" value="<%=totalTitleNum %>" id="totalTitleNum">



