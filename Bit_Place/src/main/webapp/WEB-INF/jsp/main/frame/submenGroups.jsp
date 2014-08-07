<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<script type="text/javascript">
$('#createGroupsBtn').click(function(){
		$.ajax({
		type:'GET',
		url : '/Bit_Place/ajax/groups/createGroup.do',
		async : true,
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',
		success:function(response,status,request){
			$('#body_output').empty();
			$('#body_output').append(response);	
		}
	});		
});
</script>


<div id="submenuWrapper">
<table id="submemGroupstable">
<c:forEach items="${data }" var="e">
	<tr>	   
	<td>	
	<img src='../img/top/leadericon.png'>
	</td>
	<td>
	<a href="${e.groupno }.bit" class="groupChangeBtn" id="${e.groupno }">${e.groupname}</a>
	</td>
	<td>
	<fmt:formatDate value="${e.created_date}" pattern="yyyy-MM-dd"/> 
	</td>
	</tr>
</c:forEach>
</table>

<form class="form-horizontal" role="form">
<div class="form-group form-group-sm">
<table id="createGroups">
<tr>
<td>
<div id= "createGroups_btnWrapper">
<button id="createGroupsBtn" type="button" class="btn btn-primary">GROUP 생성</button>
</div>
</td>
<td id="createGroups_tdWrapper">
<div class="col-sm-11">
<input class="form-control" id="formGroupInputSmall" type="text" name="findGroups">
</div>
</td>	
</tr>
</table>	
</div>
</form>
</div>   