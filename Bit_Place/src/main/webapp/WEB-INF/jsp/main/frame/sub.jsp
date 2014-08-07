<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix="fmt" uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript" src="../js/sub_passive.js"></script>


<style>
#datanumberresult{
	display : none;
}
</style>


<form class="form-horizontal" role="form">
  <div class="form-group form-group-sm">
    <div class="col-sm-11">
    <table>
    	<tr>
    		<td width ="30px">
    		</td>
    		<td>
    		<button type="button" class="btn btn-primary">POST</button>
    		</td>
    		<td width="30px"></td>
    		<td width ="350px">
    		<input class="form-control" type="text" id="formGroupInputSmall" placeholder="POST 검색하기">
    		</td>
    	</tr>
    </table>
    </div>
  </div>
</form>

<div id="subColumn">
	<div id="sub_date_btn">
	DATE	
	</div>
	<div id="sub_leader_btn">
	LEADER
	</div>
	<div id="sub_follower_btn">
  	FOLLOWER
	</div>
</div>

<div id="sub_data">
<table id="sub_data_table">
<% int datanumber = 0;  %>
<c:forEach items="${data }" var="e" varStatus = "no">
<%datanumber++; %>
<tr>
	<td>
	</td>
	<td>	
	<fmt:formatDate pattern="MM - dd" 
            value="${e.edited_date}" />
	</td>
	<td align="right">
	${e.content_title}
	</td>
</tr>
<tr>
	<td>
	</td>
	<td colspan="2">
	<span class="subbtn_${no.index }" id="${e.contentno }" 
	git_rep="${e.git_repository }" 
	git_id ="${e.git_id }"
	git_pwd="${e.git_pwd }">${e.content }</span>
	<img src="../img/top/leadericon.png"/>	
	</td>
</tr>
</c:forEach>
</table>
<input type="text" id="datanumberresult" value="<%=datanumber %>">
</div>